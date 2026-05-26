import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // 최대 힙으로 구현하기. (적의 숫자, 라운드 번호)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );
        int answer = 0;

        for (int idx = 0; idx < enemy.length; idx++) {
            int em = enemy[idx];

            // 적 수와 인덱스를 기록
            pq.offer(new int[]{em, idx});
            
            // 적의 수보다 남은 병력이 많으니 라운드 통과. 병력 값은 빼줌
            if (n >= em) n -= em; 
            
            else {
                // 적 수가 남은 병력보다 많으니까 까방권을 써야 함
                while (n < em) {
                    if (k == 0) return answer; // 더 이상 까방권을 쓸 수 없음
                    
                    // 까방권을 쓰기 위해서 지금까지 기록한 라운드 중, 가장 큰 병력이 나온 라운드를 가져옴 (최대힙)
                    int[] node = pq.poll();
                    int val = node[0];

                    n += val;
                    k--; // 까방권을 하나 쓴 것
                } // 남은 병력 수가 현재 라운드의 병력보다 많으면 while을 탈출

                n -= em; // 현재 라운드를 통과하려면 병력을 또 써야함
            }
            answer++; // 한 라운드가 통과되었음
        }
        return answer;
    }
}