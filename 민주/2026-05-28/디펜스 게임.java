/**
 * [핵심 아이디어]
 * 매 라운드 병사를 먼저 소모하고, 병사가 부족해지는 순간 지금까지 만난 적 중 가장 큰 라운드에 무적권을 사용한다.
 * 최대 힙을 이용해 무적권을 사용할 최적의 라운드를 그때그때 선택한다.
 *
 * [시간 복잡도]
 * O(M log M)
 * - M은 enemy.length
 * - 각 라운드마다 우선순위 큐에 삽입하고, 필요 시 삭제하므로 log M이 걸린다.
 *
 * [공간 복잡도]
 * O(M)
 * - 지금까지 만난 라운드 정보를 우선순위 큐에 저장한다.
 *
 * [정답/오답]
 * - 정답
 */

import java.util.*;

class Round {
  int enemy;
  int round;

  Round(int enemy, int round){
    this.enemy = enemy;
    this.round = round;
  }
}

class Solution {
  public int solution(int n, int k, int[] enemy) {

    PriorityQueue<Round> pq = new PriorityQueue<>(
        (a,b) -> {
          if (a.enemy != b.enemy){
            return Integer.compare(b.enemy, a.enemy);
          }
          return Integer.compare(a.round, b.round);
        }
    );

    for (int i = 0; i < enemy.length; i++){
      n -= enemy[i];
      pq.add(new Round(enemy[i], i));

      if (n  < 0) {
        //남은 무적권이 있다면
        if (k > 0){
          int round = pq.poll().round;
          k--;
          n += enemy[round];
        }
        else return i;
      }
    }
    return enemy.length;
  }
}