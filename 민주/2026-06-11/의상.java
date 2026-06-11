/**
 * [핵심 아이디어]
 * - 의상 종류별 개수를 Map에 저장한다.
 * - 각 종류마다 선택지는 "그 종류의 옷 중 하나를 입는 경우" + "아예 안 입는 경우"이다.
 * - 따라서 각 종류별로 (개수 + 1)을 곱한다.
 * - 단, 아무것도 입지 않는 경우는 제외해야 하므로 마지막에 1을 뺀다.
 *
 * [시간 복잡도]
 * - O(N)
 * - clothes 배열을 한 번 순회하고, 의상 종류를 한 번 순회한다.
 *
 * [공간 복잡도]
 * - O(K)
 * - K는 의상 종류의 개수이며, 종류별 개수를 Map에 저장한다.
 */

import java.util.*;

class Solution {
  public int solution(String[][] clothes) {
    Map<String, Integer> map = new HashMap<>();

    for (String[] cloth : clothes) {
      String type = cloth[1];
      map.put(type, map.getOrDefault(type, 0) + 1);
    }

    int answer = 1;

    for (int count : map.values()) {
      answer *= (count + 1);
    }

    return answer - 1;
  }
}

// class Solution {
//     Map<String, Integer> map = new HashMap<>();
//     List<Integer> list = new ArrayList<>();
//     int answer = 0;

//     public void dfs(int idx, int count){

//         if (idx == list.size()){
//             answer += count;
//             return;
//         }

//         dfs(idx + 1, count);
//         dfs(idx + 1, count * list.get(idx));
//     }

//     public int solution(String[][] clothes) {

//         for (String[] cloth : clothes){
//             String type = cloth[1];
//             map.put(type, map.getOrDefault(type, 0) + 1);
//         }

//         for (String key : map.keySet()){
//             list.add(map.get(key));
//         }

//         dfs(0, 1);

//         return answer - 1;
//     }
// }