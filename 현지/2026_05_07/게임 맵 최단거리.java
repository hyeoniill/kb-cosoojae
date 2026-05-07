import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        // 상하좌우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // 큐
        Queue<int[]> queue = new ArrayDeque<>();
        
        // 시작 지점
        queue.add(new int[]{0, 0, 1});
        maps[0][0] = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            // 도착 거리바놘
            if (x == n - 1 && y == m - 1) {
                return distance;
            }

            // 사방탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 맵 안벗어나고 검은거아니고
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = 0; //방문
                    queue.add(new int[]{nx, ny, distance + 1});
                }
            }
        }

        //갈수없음
        return -1;
    }
}
