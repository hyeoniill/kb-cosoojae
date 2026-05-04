import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        
        //방문 여부는 객체와 상관없이 따로 관리해주어야 함
        boolean[][] visited = new boolean[n][m];
        
        /*
        상하좌우를 모두 순회
        만약 값이 존재할 때, 현재 값보다 크다면 업데이트, 작다면 제외
        FIFO이므로 Queue 사용
        갈 수 있는 위치를 queue.add(), 차례대로 모두 순회
        순회가 끝나면 queue.poll()을 하고 다음 queue의 원소에 대해서 반복
        */
        Queue<Position> positions = new ArrayDeque<>();
        positions.add(new Position(0,0,1));
        visited[0][0] = true;
        
        //for문으로 위치 탐색
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        
        while(!positions.isEmpty()) {       //큐가 비어있게 되면 도달할 수 없음
            Position currentPos = positions.poll();
            
            //도착지점에 도달했는지 확인
            if(currentPos.x == n-1 && currentPos.y == m-1) return currentPos.cost;
            
            for(int i=0; i<4; i++) {
                int x = currentPos.x + dx[i];
                int y = currentPos.y + dy[i];
                // 범위 밖으로 넘어가는지 검사
                // 넘어간다면 건너뛰기
                if(x < 0 || x >= n || y < 0 || y >= m) continue;
                
                // 벽이 아니고 && 방문을 하지 않았다면 큐에 넣음
                if(maps[x][y] == 1 && visited[x][y] == false) {
                    visited[x][y] = true;
                    positions.add(new Position(x, y, currentPos.cost+1));
                }
            }
        }
        
        //큐가 비어 있게 되면 도착지점에 도달하지 못했으므로 -1 반환
        return -1;
    }
    class Position {
        int x;
        int y;
        int cost;
        
        public Position(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
