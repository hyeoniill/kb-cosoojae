import java.util.Arrays;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        // 알파벳 마지막 등장 위치 저장
        int[] last = new int[26]; //알파벳 26
        
        Arrays.fill(last, -1); //등장 ㄴㄴ
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int charIndex = c - 'a'; // a = 0 b= 1
            
            if (last[charIndex] == -1) { //등장여부
                // 등장한적없으면 -1
                answer[i] = -1;
            } else {
                // 등장한적있으면 현위치-마위치
                answer[i] = i - last[charIndex];
            }
            
            // 현위치 해당 마위치로 
            last[charIndex] = i;
        }
        
        return answer;
    }
}
