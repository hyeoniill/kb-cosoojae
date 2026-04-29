import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        // 문제분석
        // 섞은 음식의 스코빌 지수를 계산할 때마다, 해당 값이 가장 작다는 것을 보장할 수 없다
        // 매번 반복문을 사용해서 확인하면 시간 복잡도가 너무 커짐
        // 우선순위 큐를 활용해서 가장 작은 값이 맨 앞에 오도록 보장 -> 이후 업데이트
        
        int answer = 0;
        boolean isQualified = false; // 모든 스코빌 지수를 K이상으로 만들 수 있는지
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scv: scoville) {
            pq.offer(scv);
        }
        
        while(!isQualified && !pq.isEmpty()) {
            int curNum = pq.poll();
            
            if (curNum >= K) {
                isQualified = true;
                break;
            }
            
            if (pq.isEmpty()) {
                break;
            }
            
            int secondNum = pq.poll();
            pq.offer(curNum + 2 * secondNum); //스코빌 지수 업데이트
            answer++;   
        }
        
        if (isQualified) {
            return answer;
        } else { 
            return -1;
        }
    }
}
