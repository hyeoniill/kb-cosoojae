class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length; // 삼각형 높이 저장
        int max_num = 0; // 최댓값
        int[][] dp = new int[height][]; // dp 사용해서 최댓값 구하기...여기서 dp[i][j]는 i열j행 위치에서의 최댓값
        for (int i = 0; i < triangle.length; i++) { // dp 정의
            dp[i] = new int[triangle[i].length];
        }
        dp[0][0] = triangle[0][0]; // 맨 꼭대기 숫자 저장 (확정된 값이기 떄문에)
        for (int i = 1; i < height; i++) { // 두번째 부터 시작
            for (int j = 0; j < triangle[i].length; j++) { // 숫자에 순차적으로 접근해서
                if (j == 0) { // 맨 왼쪽에 붙어 있으면 상위 수는 확정이기 때문에
                    dp[i][j] = triangle[i][j] + dp[i - 1][j]; // 삼각형의 현재 값에 이전의 합산 수를 더한다.
                } else if (j == triangle[i].length - 1) { // 맨 오른쪽에 붙어 있으면 상위 수가 마찬가지로 확정이므로
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1]; // 삼각형의 현재 값에 이전의 합산 수를 더한다.
                } else { // 나머지 중간에 있는 수들은 두 가지 경우의 수가 존재한다.
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);// 삼각형의 현재 수에 왼쪽 위와 오른쪽 위의
                    // 최댓값을 구해서 더해준다.
                }
            }
        }
        for (int i = 0; i < dp[height - 1].length; i++) { // 만들어진 dp에서
            if (dp[height - 1][i] > max_num) { // 맨 끝에 있는 열에서
                max_num = dp[height - 1][i]; // 가장 큰 값을 구한다.
            }
        }

        return max_num; // 구한 최댓값을 반환
    }
}
