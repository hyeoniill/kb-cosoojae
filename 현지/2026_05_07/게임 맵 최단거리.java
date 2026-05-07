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
            
            // 위로 가기
            int nx1 = x + dx[0];
            int ny1 = y + dy[0];
            boolean canGo1 = nx1 >= 0;
            canGo1 = canGo1 && nx1 < n;
            canGo1 = canGo1 && ny1 >= 0;
            canGo1 = canGo1 && ny1 < m;
            canGo1 = canGo1 && maps[nx1][ny1] == 1;
            if (canGo1) {
                maps[nx1][ny1] = 0;
                queue.add(new int[]{nx1, ny1, distance + 1});
            }
            
            // 아래로 가기
            int nx2 = x + dx[1];
            int ny2 = y + dy[1];
            boolean canGo2 = nx2 >= 0;
            canGo2 = canGo2 && nx2 < n;
            canGo2 = canGo2 && ny2 >= 0;
            canGo2 = canGo2 && ny2 < m;
            canGo2 = canGo2 && maps[nx2][ny2] == 1;
            if (canGo2) {
                maps[nx2][ny2] = 0;
                queue.add(new int[]{nx2, ny2, distance + 1});
            }
            
            // 왼쪽으로 가기
            int nx3 = x + dx[2];
            int ny3 = y + dy[2];
            boolean canGo3 = nx3 >= 0;
            canGo3 = canGo3 && nx3 < n;
            canGo3 = canGo3 && ny3 >= 0;
            canGo3 = canGo3 && ny3 < m;
            canGo3 = canGo3 && maps[nx3][ny3] == 1;
            if (canGo3) {
                maps[nx3][ny3] = 0;
                queue.add(new int[]{nx3, ny3, distance + 1});
            }
            
            // 오른쪽으로 가기
            int nx4 = x + dx[3];
            int ny4 = y + dy[3];
            boolean canGo4 = nx4 >= 0;
            canGo4 = canGo4 && nx4 < n;
            canGo4 = canGo4 && ny4 >= 0;
            canGo4 = canGo4 && ny4 < m;
            canGo4 = canGo4 && maps[nx4][ny4] == 1;
            if (canGo4) {
                maps[nx4][ny4] = 0;
                queue.add(new int[]{nx4, ny4, distance + 1});
            }
        }
        
        //갈수없음
        return -1;
    }
}
