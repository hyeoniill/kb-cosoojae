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
            if (nx1 >= 0 && nx1 < n && ny1 >= 0 && ny1 < m && maps[nx1][ny1] == 1) {
                maps[nx1][ny1] = 0;
                queue.add(new int[]{nx1, ny1, distance + 1});
            }
            
            // 아래로 가기
            int nx2 = x + dx[1];
            int ny2 = y + dy[1];
            if (nx2 >= 0 && nx2 < n && ny2 >= 0 && ny2 < m && maps[nx2][ny2] == 1) {
                maps[nx2][ny2] = 0;
                queue.add(new int[]{nx2, ny2, distance + 1});
            }
            
            // 왼쪽으로 가기
            int nx3 = x + dx[2];
            int ny3 = y + dy[2];
            if (nx3 >= 0 && nx3 < n && ny3 >= 0 && ny3 < m && maps[nx3][ny3] == 1) {
                maps[nx3][ny3] = 0;
                queue.add(new int[]{nx3, ny3, distance + 1});
            }
            
            // 오른쪽으로 가기
            int nx4 = x + dx[3];
            int ny4 = y + dy[3];
            if (nx4 >= 0 && nx4 < n && ny4 >= 0 && ny4 < m && maps[nx4][ny4] == 1) {
                maps[nx4][ny4] = 0;
                queue.add(new int[]{nx4, ny4, distance + 1});
            }
        }
        
        //갈수없음
        return -1;
    }
}
