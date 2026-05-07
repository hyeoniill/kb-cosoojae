import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 1. 좌표를 모두 2배로 스케일링
        boolean[][] border = new boolean[102][102];
        boolean[][] inside = new boolean[102][102];

        // 2. 각 직사각형의 내부와 테두리를 마킹
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        // 테두리 후보 (이미 다른 사각형 내부였다면 마킹 안 함)
                        if (!inside[x][y]) border[x][y] = true;
                    } else {
                        // 내부: 테두리였더라도 취소
                        inside[x][y] = true;
                        border[x][y] = false;
                    }
                }
            }
        }

        // 3. BFS로 최단거리 탐색
        int startX = characterX * 2, startY = characterY * 2;
        int endX = itemX * 2, endY = itemY * 2;

        int[][] dist = new int[102][102];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        dist[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            if (x == endX && y == endY) break;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx > 101 || ny > 101) continue;
                if (!border[nx][ny]) continue;
                if (dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] + 1;
                queue.offer(new int[]{nx, ny});
            }
        }

        // 4. 2배 스케일이었으므로 결과를 2로 나눔
        return dist[endX][endY] / 2;
    }
}