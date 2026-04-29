import java.util.PriorityQueue;


class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        //작은 숫자가 우선순위가 높은 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville){
            pq.add(i);
        }
        // 모두 완성되거나 1개 이상이면 반복
        while(pq.size()>1 && pq.peek() < K){
            // 우선순위가 높은 작은 숫자부터 먼저 나온다
            int a = pq.poll();
            int b = pq.poll();
            pq.add(a+2*b);
            answer++;
        }
        if(pq.peek()<K) return -1; // 위 과정 반복했는데도 완성되지 않았다면 -1
        return answer;
    }
}
