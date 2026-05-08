N: 행, M: 열
시간복잡도: O(N x M)
공간복잡도: O(N x M)

import java.util.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int solution(int[][] maps) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // 상하좌우 4방향 확인
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 1. 미로 범위를 벗어나면 무시
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
                // 2. 벽(0)이면 무시
                if (maps[nx][ny] == 0) continue;

                // 3. 처음 방문하는 길(1)인 경우에만 진행
                if (maps[nx][ny] == 1) {
                    // 이전 칸의 거리 + 1을 현재 칸에 기록 (방문 처리 겸용)
                    maps[nx][ny] = maps[current.x][current.y] + 1;
                    queue.add(new Point(nx, ny));
                }
            }
        }
        
        return maps[maps.length - 1][maps[0].length - 1] == 1 ? -1 : maps[maps.length - 1][maps[0].length - 1];
    }
}
