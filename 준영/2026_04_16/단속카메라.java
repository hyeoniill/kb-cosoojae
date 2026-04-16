import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int line;
        int camera = 1;
        Arrays.sort(routes, (o1, o2) -> { // 크기 순서대로 정렬
            return o1[1] - o2[1]; // 끝 지점을 기준으로 오름차순 정렬
        });
        line = routes[0][1];
        for (int i = 0; i < routes.length; i++) { // 순차적으로 접근해서
            if (routes[i][0] <= line && routes[i][1] >= line) { // 선이 차가 지나간 차로 사이에 있다면
                continue; // 넘어가기
            } else { // 그렇지 않다면 새로운 선을 정한다.
                camera++;
                line = routes[i][1];
            }
        }
        answer = camera;
        return answer;
    }
}
