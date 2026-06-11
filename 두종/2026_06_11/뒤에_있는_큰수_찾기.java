import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        // 뒤큰수 후보를 담을 자료구조 활용
        // 뒤에서부터 순회 시작
        
        int[] answer = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = numbers.length - 1; i >= 0; i--) {
            int curNum = numbers[i];
  
            while (!stack.isEmpty() && stack.peek() <= curNum) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(curNum);
        }
        
        return answer;
    }
}
