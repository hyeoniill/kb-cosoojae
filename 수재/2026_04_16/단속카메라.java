package ct;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int answer = 1;
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};

        // 정렬 {{-20, -15}, {-18, -13}, {-14, -5}, {-5, -3}}
        Arrays.sort(routes, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]); // 내림차순
            }
            return Integer.compare(a[0], b[0]);     // 오름차순
        });

        // 첫번째 배열의 2번째 항, 정렬한 다음 불러와야됨
        int n = routes[0][1];
        // 배열 하나씩 불러오기
        for (int[] route : routes) {
            if (route[0] > n) {
                // 카메라 설치
                n = route[1];
                // 설치 수
                answer += 1;
            }
        }

        // Arrays.toString(배열) = 1차원 배열용, 아래는 다차원 배열용
        System.out.println(Arrays.deepToString(routes));
        System.out.println(answer);
    }
}

// 실패 --------------------------------------------------
// 배열 {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}, {-12, -7}}
// 정렬 {{-20, -15}, {-18, -13}, {-14, -5}, {-12, -7}, {-5, -3}}

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        // 정렬
        Arrays.sort(routes, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int n = routes[0][1];
        for (int[] route : routes) {
            if (route[0] > n) {
                n = route[1];
                answer += 1;
            }
        }

        return answer;
    }
}

// 성공 --------------------------------------------------
// 배열 {{-20, -15}, {-14, -13}, {-18, -15}, {-5, -3}, {-20, -7}}
// 정렬 {{-18, -15}, {-20, -15}, {-14, -13}, {-20, -7}, {-5, -3}}
