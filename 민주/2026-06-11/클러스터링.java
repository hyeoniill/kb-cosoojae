/**
 * [핵심 아이디어]
 * - 두 문자열을 소문자로 변환한 뒤, 연속된 2글자씩 잘라 다중집합을 만든다.
 * - 이때 두 글자가 모두 영문자인 경우만 원소로 사용한다.
 * - Map<String, Integer>를 사용해 각 원소의 등장 횟수를 저장한다.
 * - 교집합은 같은 원소의 최소 등장 횟수, 합집합은 최대 등장 횟수로 계산한다.
 * - 두 집합이 모두 공집합이면 자카드 유사도를 1로 처리한다.
 *
 * [시간 복잡도]
 * - 문자열 길이를 각각 N, M이라고 할 때 O(N + M)
 * - 두 문자열을 한 번씩 순회하고, Map의 key들을 순회한다.
 *
 * [공간 복잡도]
 * - O(N + M)
 * - 각 문자열에서 생성된 2글자 원소들을 Map에 저장한다.
 */

import java.util.*;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

import java.util.*;

class Solution {
  public int solution(String str1, String str2) {
    Map<String, Integer> map1 = makeMap(str1);
    Map<String, Integer> map2 = makeMap(str2);

    int intersection = 0;
    int union = 0;

    for (String key : map1.keySet()) {
      if (map2.containsKey(key)) {
        intersection += Math.min(map1.get(key), map2.get(key));
        union += Math.max(map1.get(key), map2.get(key));
      } else {
        union += map1.get(key);
      }
    }

    for (String key : map2.keySet()) {
      if (!map1.containsKey(key)) {
        union += map2.get(key);
      }
    }

    if (union == 0) {
      return 65536;
    }

    return (int)(65536 * ((double) intersection / union));
  }

  private Map<String, Integer> makeMap(String str) {
    Map<String, Integer> map = new HashMap<>();

    str = str.toLowerCase();

    for (int i = 0; i < str.length() - 1; i++) {
      String part = str.substring(i, i + 2);

      if (isValid(part)) {
        map.put(part, map.getOrDefault(part, 0) + 1);
      }
    }

    return map;
  }

  private boolean isValid(String str) {
    return str.charAt(0) >= 'a' && str.charAt(0) <= 'z'
        && str.charAt(1) >= 'a' && str.charAt(1) <= 'z';
  }
}

// class Solution {
//     public int solution(String str1, String str2) {
//         //대소문자 통일
//         str1 = str1.toLowerCase();
//         str2 = str2.toLowerCase();

//         Map<String, Integer> map1 = new HashMap<>();
//         Map<String, Integer> map2 = new HashMap<>();

//         String regex = "[^a-z]";
//         Pattern pattern = Pattern.compile(regex);
//         Matcher matcher;

//         int union = 0;
//         int intersection = 0;

//         for (int i = 0; i < str1.length() - 1; i++){
//             String str = str1.substring(i, i + 2);
//             matcher = pattern.matcher(str);
//             //영어 소문자가 아닌 경우 (특수문자)
//             if (!matcher.find()){
//                 map1.put(str, map1.getOrDefault(str, 0) + 1);
//             }
//         }

//         for (int i = 0; i < str2.length() - 1; i++){
//             String str = str2.substring(i, i + 2);
//             matcher = pattern.matcher(str);
//             //영어 소문자가 아닌 경우 (특수문자)
//             if (!matcher.find()){
//                 map2.put(str, map2.getOrDefault(str, 0) + 1);
//             }
//         }

//         for (String key : map1.keySet()){
//             if (map2.containsKey(key)){
//                 intersection += Math.min(map1.get(key), map2.get(key));
//                 union += Math.max(map1.get(key), map2.get(key));
//             }
//             else {
//                 union += map1.get(key);
//             }
//         }

//         for (String key : map2.keySet()){
//             if (!map1.containsKey(key)){
//                  union += map2.get(key);
//             }
//         }


//         if (intersection == 0) {
//             if (union != 0){
//                 return 0;
//             }
//             return (int) 65536;
//         }
//         System.out.println(intersection + " " + union);
//         return (int) (65536 * ((double)intersection / union));
//     }
// }