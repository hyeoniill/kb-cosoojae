import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stackInt = new Stack<>();
        
        for (int i=0; i<number.length(); i++){
            //
            char currInt = number.charAt(i);
            while(k>0 && !stackInt.empty() && stackInt.peek() < currInt){
                stackInt.pop();
                k -= 1;
            }
            stackInt.push(currInt);
        }
        if(k>0){
            for(int i=0; i<k; i++){
                stackInt.pop();
            }
        }
        // System.out.println(stackInt);
        StringBuilder sb = new StringBuilder();
        
        for(char c : stackInt){
            sb.append(c);
        }
        
        String answer = sb.toString();
        
        return answer;
    }
}