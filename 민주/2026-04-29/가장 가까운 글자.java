/**
 * 1. 단순 배열 활용
 * [핵심 아이디어]
 * - 이중 for문 사용
 * - 기준 글자를 두고 뒤에서 앞으로 탐색하며 최초의 같은 글자와의 거리를 탐색
 *
 * [시간 복잡도]
 * - O(N^2)
 *
 * [공간 복잡도]
 * - O(N)
 *
 * [정답/오답]
 * - 정답
 *
 */

//class Solution {
//  public int[] solution(String s) {
//    int[] answer = new int[s.length()];
//
//    for (int i = 0; i < s.length(); i++) {
//      int dist = -1;
//
//      for (int j = i - 1; j >= 0; j--) {
//        if (s.charAt(i) == s.charAt(j)) {
//          dist = i - j;
//          break;
//        }
//      }
//
//      answer[i] = dist;
//    }
//
//    return answer;
//  }
//}

/**
 * 2. Map 활용
 * [핵심 아이디어]
 * - Map에 (글자, 인덱스) 를 저장
 * - 단어를 순회하면서 map에 글자가 저장되어있는지 확인 후 거리 계산
 *
 * [시간 복잡도]
 * - O(N)
 *
 * [공간 복잡도]
 * - O(N)
 *
 * [정답/오답]
 * - 정답
 *
 */

import java.util.*;

class Solution {
  public int[] solution(String s) {

    Map<Character, Integer> m = new HashMap();

    //결과 담을 배열
    int[] result = new int[s.length()];

    char[] c = s.toCharArray();
    for (int i = 0; i < c.length; i++){
      // 이전에 같은 글자가 없었던 경우 -> i - (i + 1) = -1
      // 이전에 같은 글자가 있었던 경우 -> i - c[i]
      result[i] = i - m.getOrDefault(c[i], i + 1);

      //글자의 인덱스를 업데이트
      m.put(c[i], i);
    }
    return result;
  }
}
