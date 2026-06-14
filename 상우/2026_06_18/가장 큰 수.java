import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        //숫자를 문자열로 변환
        for(int i = 0; i <numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));   //정렬
        
        //모두 0인 경우
        if(arr[0].equals("0")) {
            return "0";
        }
        
        //결과 이어붙이기
        StringBuilder sb = new StringBuilder();
        
        for(String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }
}
