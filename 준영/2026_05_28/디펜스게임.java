import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < enemy.length; i++){
            int e = enemy[i];   // 현재 웨이브 양
            
            // 감당 가능한 경우
            if (n >= e){
                q.offer(e);
                n -= e;
                answer++;
            }
            
            // 감당 불가능한 경우 - 무적권 있는 경우
            else if (e > n && k > 0){
                if (q.isEmpty()){   // 들어간 수가 없는 경우
                    k--;
                    answer++;
                }
                else{
                    int num = q.poll(); // 과거에 적의 수가 가장 많은 경우
                    if (num > e){   // 과거에 무적권 사용
                        k--;
                        q.offer(e);
                        n += num;
                        n -= e;
                        answer++;
                    }
                    else{
                        k--;
                        q.offer(num);
                        answer++;
                    }
                }
            }
            // 감당 불가능한 경우 - 무적권 X
            else if (e > n && k == 0){
                break;
            }
        }
        
        return answer;
    }
}
