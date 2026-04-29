/**
 * 1. list 사용
 *
 * [핵심 아이디어]
 * - list를 매번 정렬하면서 새 스코빌 지수를 계산하여 넣어줌
 *
 * [시간 복잡도]
 * - O(N^2logN)
 *
 * [공간 복잡도]
 * - O(N)
 *
 * [정답/오답]
 * - 오답
 */

//import java.util.*;
//
//class Solution {
//  public int solution(int[] scoville, int K) {
//    int count = 0;
//    List<Integer> list = new ArrayList<>();
//    for (int s : scoville) {
//      list.add(s);
//    }
//
//    while (list.size() >= 2) {
//      Collections.sort(list);
//
//      if (list.get(0) >= K) {
//        return count;
//      }
//
//      int first = list.remove(0);
//      int second = list.remove(0);
//      int mixed = first + second * 2;
//
//      list.add(mixed);
//      count++;
//    }
//
//    if (list.size() == 1 && list.get(0) >= K) {
//      return count;
//    }
//
//    return -1;
//  }
//}

/**
 * 2. Priority Queue(우선순위 큐) 사용
 *
 * [핵심 아이디어]
 * - 우선순위 큐 활용하여 정렬
 *
 * [시간 복잡도]
 * - O(NlogN)
 *
 * [공간 복잡도]
 * - O(N)
 *
 * [정답/오답]
 * - 정답
 */

import java.util.*;

class Solution {
  public int solution(int[] scoville, int K) {

    //pq 선언 후 스코빌 지수 넣기
    PriorityQueue<Integer> pq = new PriorityQueue();
    for (int s : scoville){
      pq.add(s);
    }

    int count = 0;
    while(!pq.isEmpty()){

      //맨 앞 스코빌 지수 (제알 안 매운 거) 가 K 이상이면 리턴
      if (pq.peek() >= K){
        return count;
      }

      //---아래는 제일 안 매운 지수도 K 미만인 상황---

      // 단 하나의 지수로는 K 이상을 만들 수 없으므로 리턴
      if (pq.size() == 1) {
        return -1;
      }

      int s1 = pq.poll();
      int s2 = pq.poll();

      pq.add(s1 + 2 * s2);
      count++;
    }

    //여기 도달할 일 없을듯?
    return -1;
  }
}