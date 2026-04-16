import java.util.ArrayDeque;
//import.java.util.*;
class Solution {
    public String solution(String number, int k) {
        ArrayDeque<Character>deque = new ArrayDeque<>();
        char [] arr = number.toCharArray();
        deque.push(arr[0]);
        for (int i=1; i<=arr.length-1; i++ ){
            while(!deque.isEmpty() && arr[i] > deque.peek() && k!=0){
                deque.pop(); //i빼고
                k = k-1; //k가 0이 될때까지
            }
            deque.push(arr[i]); //i 빼고
        }
        
        while(k!=0){
            deque.pop();
            k =k-1; // k가 남을때
        }
        
        StringBuilder sb = new StringBuilder(); //선언
        //removeFirst();
      while(!deque.isEmpty()) { 
          sb.append(deque.removeLast());
      } //스택에 아무것도 없을 때까지
        return sb.toString();
    }
}
