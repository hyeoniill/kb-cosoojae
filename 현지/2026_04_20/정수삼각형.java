class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        
        for (int i = n - 2; i >= 0; i--) { //초기화 바닥부터 시작
            for (int j = 0; j <= i; j++) {
                //triangle[i + 1]; //현재 줄 바로위 
                //triangle[i + 1][j]; //대각선 왼
                //triangle[i + 1][j + 1]; //대각선 오
                int left = triangle[i + 1][j];
                int right = triangle[i + 1][j + 1];
                if (left < right ){ //만약에
                    triangle[i][j] += right;
                }//오가 클때
                if (left > right){
                    triangle[i][j] += left;
                }//왼이 클때
                
            }
        }
        
        return triangle[0][0];
    }
}
