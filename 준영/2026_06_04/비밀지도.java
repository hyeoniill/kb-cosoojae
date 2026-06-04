class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++){
            String m1 = Integer.toBinaryString(arr1[i]);
            String m2 = Integer.toBinaryString(arr2[i]);
            while (m1.length() < n){        // 길이를 n으로 맞추기
                m1 = "0" + m1;
            }
            while(m2.length() < n){
                m2 = "0" + m2;
            }
            
            char[] ch1 = m1.toCharArray();
            char[] ch2 = m2.toCharArray();
            String a = "";
            for (int j = 0; j < n; j++){
                if (ch1[j] == '1' || ch2[j] == '1'){
                    a = a + "#";
                }
                else{
                    a = a + " ";
                }
            }
            answer[i] = a;
        }
        return answer;
    }
}
