import java.util.ArrayDeque;

class Solution {
    public String solution(String number, int k) {
        //스택으로 쓸 deque
        ArrayDeque<Character> ad = new ArrayDeque();
        //출력시간 절약
        StringBuilder sb = new StringBuilder();

        for (char c : number.toCharArray()){
            //만약 앞 요소가 더 작다면 없애고 넣기
            while(!ad.isEmpty() && ad.peek() < c && k > 0){
                ad.removeFirst();
                k--;
            }
            ad.push(c);
        }
        //앞에서 제거를 안한 경우 뒤에서 제거해주기
        while(k > 0){
            ad.removeFirst();
            k--;
        }

        while(!ad.isEmpty()){
            sb.append(ad.removeLast());
        }
        return sb.toString();
    }
}
