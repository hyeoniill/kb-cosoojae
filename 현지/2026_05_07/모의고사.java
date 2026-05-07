class Solution {
    public int[] solution(int[] answers) {
        int[] A = {1, 2, 3, 4, 5}; //5칸
        int[] B = {2, 1, 2, 3, 2, 4, 2, 5}; //8칸
        int[] C = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10칸
        
        int s1 = 0;
        int s2 = 0;
        int s3 = 0;
        
        for (int i = 0; i < answers.length; i++) { //하나씩 비교
            if (answers[i] == A[i % 5]) s1++; 
            if (answers[i] == B[i % 8]) s2++;
            if (answers[i] == C[i % 10]) s3++;
        }
        
        int max = s1; //가장 높은 점수찾기
        if (s2 > max) max = s2;
        if (s3 > max) max = s3;
        
        int count = 0; //높은 점수 몇명인지
        if (s1 == max) count++;
        if (s2 == max) count++;
        if (s3 == max) count++;
        
        int[] answer = new int[count]; //배열 나열하고 리턴하기
        int index = 0;
        if (s1 == max) answer[index++] = 1;
        if (s2 == max) answer[index++] = 2;
        if (s3 == max) answer[index++] = 3;
        
        return answer;
    }
}
