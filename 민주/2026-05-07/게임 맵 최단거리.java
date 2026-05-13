/**
 * [핵심 아이디어]
 * - bfs
 * - distance(거리) 배열을 방문 여부 확인용으로 사용
 *
 * [시간 복잡도]
 * - O(NM)
 *
 * [공간 복잡도]
 * - O(NM)
 *
 * [정답/오답]
 * - 정답
 */

import java.util.*;
class Solution {
    //전역변수
    //맵, 맵의 X,Y 길이
    int[][] maps;
    int mapX;
    int mapY;

    //상하좌우 움직일 시 좌표의 변동
    int[] dx = {0,0,-1,1};
    int[] dy = {1,-1,0,0};

    //좌표 저장 클래스
    class Route {
        int x;
        int y;

        public Route(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    //bfs
    public int findWay(){
        ArrayDeque<Route> ad = new ArrayDeque();

        ad.add(new Route(0,0));
        maps[0][0] = 1;

        //큐가 비어있지 않을 동안 반복
        while(!ad.isEmpty()){

            Route curr = ad.poll();
            int x = curr.x;
            int y = curr.y;
            //거리는 map에 덮어씌우기
            int dist = maps[y][x];

            //만약 상대편 진영에 도달했다면 거리 반환
            if (x == mapX - 1 && y == mapY - 1) return maps[y][x];

            //상하좌우 좌표 돌면서 가능한 좌표 찾기
            for (int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (checkAvailable(newX, newY)){
                    ad.add(new Route(newX, newY));
                    maps[newY][newX] = dist + 1;
                }
            }
        }
        //모든 가능한 칸을 돌았지만 상대편 진영에 도달하지 못한 경우
        return -1;
    }

    //해당 좌표로 이동 가능한지
    public boolean checkAvailable(int x, int y){
        if (x < 0 || y < 0 || x > mapX - 1 || y > mapY - 1) return false;
        //0인 경우 -> 못감 / 1인 경우 -> 갈 수 있음 / 2 이상인 경우 -> 이미 방문
        if (maps[y][x] != 1) return false;
        return true;
    }

    public int solution(int[][] maps) {
        mapX = maps[0].length;
        mapY = maps.length;
        this.maps = maps;
        return findWay();
    }
}
