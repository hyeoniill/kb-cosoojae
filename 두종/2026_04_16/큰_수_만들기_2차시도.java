import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuffer sb = new StringBuffer();
        Deque<Integer> dq = new ArrayDeque<>();

        int sLen = number.length();
        int toFindCnt = sLen - k;
        int currentIndex = 0;

        while (toFindCnt > 0 || currentIndex < sLen) {
            int curNum = number.charAt(currentIndex) - '0';
            if (dq.isEmpty()) {
                dq.offer(curNum);
                currentIndex++;
                toFindCnt--;
            } else {
                if (dq.peekLast() < curNum && currentIndex < sLen - toFindCnt) {
                    while (!dq.isEmpty() &&
                            dq.peekLast() < curNum &&
                            currentIndex < sLen - toFindCnt) {
                        dq.pollLast();
                        toFindCnt++;
                    }
                    dq.offerLast(curNum);
                    currentIndex++;
                    toFindCnt--;
                } else {
                    dq.offerLast(curNum);
                    currentIndex++;
                    toFindCnt--;
                }
            }
        }

        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }

        return sb.toString();
    }
}