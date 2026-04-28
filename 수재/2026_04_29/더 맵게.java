// 시간복잡도: O(n log n)
// 공간복잡도: O(n)

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐

        for (int scv : scoville) {
            pq.add(scv); // 배열 -> 큐에 삽입
        }

        for(;;){
            int a = pq.poll();
            if ((a >= K)) break; // 가장 작은 값 스코빌지수 비교
            if (answer == scoville.length - 1) {answer = -1; break;} // 위 조건을 통과했는데 큐의 크기가 1이면 -1저장
            int b = pq.poll();
            pq.add(a + (b * 2));
            answer += 1;
        }
        
        return answer;
    }
}

최적화--------------------------------------------------

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐

        for (int scv : scoville) {
            pq.add(scv); // 배열 -> 큐에 삽입
        }

        while (pq.peek() < K) { // 가장 작은 값이 K보다 작은지
            if (pq.size() < 2) return -1; // 큐의 크기가 1일때 -1리턴
            
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a + (b * 2));
            answer++;
        }
        
        return answer;
    }
}
