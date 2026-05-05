import java.util.*;

//BFS
//4방향 탐색 (dx, dy), 방문 체크
class Solution {
    public int solution(int[][] maps) {

        int n = maps.length;        //행 크기(세로)
        int m = maps[0].length;     //열 크기(가로)

        //아래, 위, 오른쪽, 왼쪽
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        //BFS용 큐 생성(x, y, 거리)
        Queue<int[]> queue = new LinkedList<>();
        
        //시작점 (0,0), 거리 1, 시작도 포함해서 거리 1로 시작
        queue.add(new int[]{0, 0, 1});

        //방문 체크 배열
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        //BFS 시작
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();   //큐에서 하나 꺼냄
            //현재 위치 + 현재까지 거리
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            //도착지 도착하면 바로 종료
            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            //4방향 탐색
            for (int i = 0; i < 4; i++) {
                //다음 좌표 계산
                int nx = x + dx[i];
                int ny = y + dy[i];

                //맵 범위 안인지 확인
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {

                    //길(1)이고 아직 방문 안한 경우
                    if (maps[nx][ny] == 1 && !visited[nx][ny]) {

                        visited[nx][ny] = true;  //방문 처리

                        queue.add(new int[]{nx, ny, dist + 1});  //다음 위치 + 거리 증가
                    }
                }
            }
        }
        return -1;  //도착 못 하면 -1
    }
}
