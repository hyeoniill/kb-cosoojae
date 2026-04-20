class Solution {
    public int solution(int[][] triangle) {
        /*
        7
        3 8
        8 1 0
        2 7 4 4
        4 5 2 6 5
        
        7
        10 15
        18 16 15
        20 25 20 19
        24 30 27 26 24
        */
        
        int[][] S = triangle.clone(); //원본 배열 복사
            
        for (int i = 1; i < triangle.length; i++) {
            S[i][0] += S[i-1][0];
            for (int j = 1; j <= i; j++) {
                if (j == i) { 
                    // j == i 인 경우에는 이전 행(i-1)에 j열이 없기 때문에 j-1 열의 값을 그대로 사용
                    S[i][j] += S[i-1][j-1];
                } else {
                    S[i][j] += Math.max(S[i-1][j-1], S[i-1][j]);   
                }
            }
        }
        
        int answer = 0;
        for (int num: S[S.length - 1]) {
            if (num > answer) answer = num;
        }
        
        return answer;
    }
}
