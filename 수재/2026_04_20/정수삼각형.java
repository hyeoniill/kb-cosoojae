import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
    
        int n = triangle.length;
        // Dynamic Programming, 동적 계획법
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) { // 젤 위는 이미 담겨 있어서 1부터
            for (int j = 0; j <= i; j++) {
                if (j == 0) { // 가장 왼쪽은 받아오는게 오른쪽 위로 고정
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (j == i) { // 가장 오른쪽은 받아오는게 왼쪽 위로 고정
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else { // 상위중 더 큰거 받아오기
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[n-1][j]);
        }
        return answer;
    }
}

// 위에는 새로운 배열 선언해서 값넣기, 아래는 기존 triangle에 더하면서 내려가기
// 공간적 효율성

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;

        // 1번째 줄(index 0)은 더할 게 없으므로 2번째 줄(index 1)부터 시작
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    // 맨 왼쪽: 내 바로 위(같은 열 index) 값을 더함
                    triangle[i][j] += triangle[i-1][j];
                } else if (j == i) {
                    // 맨 오른쪽: 내 왼쪽 위(이전 열 index) 값을 더함
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    // 가운데: 내 바로 위와 왼쪽 위 중 큰 값을 더함
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }

        // 마지막 줄에서 최댓값 찾기
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, triangle[n-1][j]);
        }
        
        return answer;
    }
}

// Bottom-Up(상향식) 방식 --------------------------------------------------

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        // 밑에서 두 번째 줄부터 꼭대기까지 올라감
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 내 바로 아래(i+1, j)와 오른쪽 아래(i+1, j+1) 중 더 큰 값을 골라 현재 칸에 더함
                // 아래쪽 줄은 이미 최댓값들로 채워져 내려온 상태라고 가정
                triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]);
            }
        }

        // 모든 계산이 끝나면 삼각형의 꼭대기에 전체 경로의 최댓값이 저장됩니다.
        return triangle[0][0];
    }
}
