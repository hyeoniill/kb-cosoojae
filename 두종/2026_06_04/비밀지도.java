class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {        
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String binaryExp = Integer.toBinaryString(arr1[i] | arr2[i]);
            
            if (binaryExp.length() != n) {
                String prefix = "0".repeat(n - binaryExp.length());
                binaryExp = prefix + binaryExp;
            }
            answer[i] = binaryExp.replace("1", "#").replace("0", " ");
        }
        
        return answer;
    }
}
