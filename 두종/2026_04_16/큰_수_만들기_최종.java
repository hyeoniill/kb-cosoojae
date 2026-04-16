import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuffer sb = new StringBuffer();

        // 숫자를 순차적으로 저장하기 위한 자료구조
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            int curNum = number.charAt(i) - '0';

            // Deque 뒤에서부터 순차적으로 poll 하면서 현재 숫자를 앞으로 이동
            while (!dq.isEmpty() && k > 0 && dq.peekLast() < curNum) {
                dq.pollLast();
                k--;
            }
            // 기본적으로는 숫자를 Deque에 저장
            dq.offerLast(curNum);
        }

        // 아직 삭제해야할 숫자가 남았다면 뒤에서부터 순차적으로 삭제
        while (k > 0) {
            dq.pollLast();
            k--;
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }

        return sb.toString();
    }
}