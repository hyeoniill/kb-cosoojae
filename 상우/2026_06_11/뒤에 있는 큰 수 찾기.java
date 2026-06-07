import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);    //뒷큰수 없는 경우 -1
        Stack<Integer> stack = new Stack<>();   //숫자 아니고 인덱스 저장
        
        for(int i = 0; i < n; i++) {
            //현재 숫자가 스택에 있는 숫자보다 크면
            while(!stack.isEmpty() &&
                 numbers[i] > numbers[stack.peek()]) {
                answer[stack.pop()] = numbers[i];   //뒷 큰수 저장
            }
            stack.push(i);  //현재 인덱스 저장
        }
        return answer;
    }
}
