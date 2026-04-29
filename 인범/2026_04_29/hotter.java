import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.add(scoville[i]);
        }
        
        while(true){
            if(pq.peek()<K && pq.size()>=2){
                int lowest = pq.poll();
                int lower = pq.poll();
                int comp = lowest + lower*2;
                pq.add(comp);
                answer++;
            }  
            else{
                break;
            }
        }
        if(pq.peek()>=K){return answer;}
        else{return -1;}
    }
}