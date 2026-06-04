class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i =0; i<n; i++){
            String Temp = "";
            int num = arr1[i] | arr2[i];
            for (int j=0; j<n; j++){
                int k = 1<<j;
                if ((num & k) == k) {
                    Temp = "#" + Temp;
                }
                else {
                    Temp = " " + Temp;
                }
            }
            answer[i]= Temp;
        }
        
        return answer;
    }
}