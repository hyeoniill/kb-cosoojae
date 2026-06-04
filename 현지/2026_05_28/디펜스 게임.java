import java.util.*;

class Solution {

    public int solution(int n, int k, int[] enemy) {

        int answer = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(int i = 0; i < enemy.length; i++) {

            q.offer(enemy[i]);

            // 무적권 넘으면
            if(q.size() > k) {

                int a = q.poll();

                n = n - a;
            }

            // 병사 없으면
            if(n < 0) {

                answer = i;

                return answer;
            }
        }

        answer = enemy.length;

        return answer;
    }
}
