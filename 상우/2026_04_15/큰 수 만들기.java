import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++){
            char cur = number.charAt(i);
            
            // 스택이 비어있지 않고, 제거할 수 있고,
            // 스택 맨 위 숫자가 현재 숫자보다 작으면 제거
            while(!stack.isEmpty() && k > 0 && stack.peek() < cur){
                stack.pop();
                k--;
            }
            stack.push(cur);
        }
        
        // 아직 제거 횟수가 남아있다면 뒤에서 제거
        while(k > 0){
            stack.pop();
            k--;
        }
        
        // 스택을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size(); i++){
            char c = stack.get(i);
            sb.append(c);
        }
        return sb.toString();
    }
}
