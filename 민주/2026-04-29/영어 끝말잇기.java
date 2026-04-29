/**
 * [핵심 아이디어]
 * - Set 사용해서 중복 체크
 * - 앞단어의 맨 뒤 글자와 뒤 단어의 맨 앞 글자가 같은지 체크
 *
 * [시간 복잡도]
 * - O(N)
 *
 * [공간 복잡도]
 * - O(N)
 *
 * [정답/오답]
 * - 정답
 */

import java.util.*;

class Solution {
  public int[] solution(int n, String[] words) {
    Set<String> set = new HashSet();
    char lastLetter = ' ';

    for (int i = 0; i < words.length; i++){

      if (!set.isEmpty() && (lastLetter != words[i].charAt(0) ||
          set.contains(words[i]))) {
        return new int[]{(i % n) + 1, (i / n) + 1};
      }

      set.add(words[i]);
      lastLetter = words[i].charAt(words[i].length() - 1);

    }
    return new int[] {0,0};
  }
}
