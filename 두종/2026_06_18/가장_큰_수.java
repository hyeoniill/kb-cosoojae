import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        //문자열 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        //내림차순 정렬
        Arrays.sort(strNumbers, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s: strNumbers) {
            sb.append(s);
        }
        
        //엣지 케이스 처리
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
