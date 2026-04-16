//문제 이해는 했는데 코드로 구현하는법을 몰라서 재미니에게 질문해서 나온 결과값
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] routes) {
        // 1. 진출 지점(index 1)을 기준으로 오름차순 정렬
        // 람다식을 사용하여 2차원 배열의 두 번째 요소를 비교합니다.
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int answer = 0;
        // 2. 카메라 위치 초기화 (문제 범위인 -30,000보다 작은 값)
        int lastCamera = -30001;

        for (int[] route : routes) {
            // 3. 현재 카메라가 차량의 진입 지점(route[0])보다 앞에 있다면
            if (lastCamera < route[0]) {
                // 새 카메라를 설치하고 위치를 현재 차량의 진출 지점으로 갱신
                answer++;
                lastCamera = route[1];
            }
        }

        return answer;
    }
}
