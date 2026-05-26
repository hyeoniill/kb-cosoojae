시간복잡도: O(N)
공간복잡도: O(N)

import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        // 첫글자 대문자
        boolean spc = true;
        
        for (char c : s.toCharArray()) {
            if (c == ' ') { // 띄어쓰기 다음은 대문자
                answer.append(c);
                spc = true;
            }
            else if (spc == true) {
                answer.append(Character.toUpperCase(c));
                spc = false;
            }
            else {
                answer.append(Character.toLowerCase(c));
            }
        }
        
        return answer.toString();
    }
}
