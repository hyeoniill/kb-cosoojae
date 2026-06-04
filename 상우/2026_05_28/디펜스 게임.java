import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  //최소 힙(작은 값이 먼저 나옴)
        
        //모든 라운드 진행
        for(int i = 0; i < enemy.length; i++) {
            pq.add(enemy[i]);   //현재 라운드 적 수 저장
            
            //무적권보다 적이 많으면
            if(pq.size() > k) {
                n -= pq.poll(); //가장 적은 적을 병사로 막기
            }
            
            //병사가 부족하면 종료
            if(n < 0) {
                return i;
            }
        }
      
        return enemy.length;  //끝까지 막았으면 전체 라운드 수 반환
    }
}
