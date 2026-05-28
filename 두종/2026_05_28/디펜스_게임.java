import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // enemy의 길이가 최대 10^6 -> O(nlogn) 사용 가능
        // 일단 무적권을 쓰지 않고 막을 수 있는 최대치까지 전진
        // 전진한 인덱스까지의 숫자들 정렬 후 큰 값 부터 무적권 사용
        // 무적권을 1번 사용한 후에는 추가로 갈 수 있는 인덱스까지 다시 전진
        // 전진할 때마다 해당 숫자를 정렬된 배열에서 적절한 위치에 놓아야 하는데..
        // 우리에게 중요한 건 결국 정렬된 배열에서 가장 큰 숫자
        // Max Heap을 사용하면 되지 않을까?
        // 무적권을 사용할 수 있을 때까지 계속 사용후 최대 라운드 return
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int answer = enemy.length;
        
        for (int i = 0; i < enemy.length; i++) {
            if (n - enemy[i] >= 0) {
                pq.add(enemy[i]);
                n -= enemy[i];
            } 
            else {
                if (k > 0) {
                    pq.add(enemy[i]);
                    n -= enemy[i];
                    n += pq.poll();
                    k--;
                }
                else {
                    answer = i;
                    break;
                }
                
            }
        }
        
        return answer;
    }
}
