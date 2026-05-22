/* 디펜스게임 No.142085 */

import java.util.*;
class Solution {
    int answer = 0;
    public int solution(int n, int k, int[] enemy) {
        
        /*
            우선순위 큐를 통해서 정렬된 값을 저장하는 것이 필요
            Collections.reverseOrder()를 통해서 내림차순으로 정의해야 큰 값을 뺼 수 있음
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());

        /*
            n에서 enemy[i]를 빼고 pq에 넣으면서 n이 음수가 되면 무적권이 있으면 가장 큰 값을 뺴주고,
            계속 진행할 수 있음
        */
        for(int i=0; i<enemy.length; i++) {
            n -= enemy[i];
            pq.offer(enemy[i]);
            if (n < 0) {
                if (k == 0) {   //무적권이 없으면 더이상 진행이 불가능하기 떄문에 i리턴
                    return i;
                }
                //무적권이 있으면 pq에서 가장 큰 값
                n += pq.poll();
                k--;
            }
        }
        return enemy.length;
    }
}
