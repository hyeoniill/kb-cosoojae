/**
 * [핵심 아이디어]
 * 각 지원자 정보를 `-`를 포함한 16가지 조건 조합으로 미리 저장해두고,
 * 쿼리는 해당 조건의 점수 리스트에서 이분 탐색으로 기준 점수 이상인 인원을 센다.
 *
 * [시간 복잡도]
 * O(N * 16 + K log K + Q log K)
 * - N은 info.length, Q는 query.length
 * - 각 info마다 16개의 조합을 생성한다.
 * - 각 key별 점수 리스트를 정렬한다. 전체적으로 O(K log K), K는 저장된 점수 개수이며 최대 16N이다.
 * - 각 query마다 이분 탐색을 수행하므로 O(Q log K)이다.
 *
 * [공간 복잡도]
 * O(16N)
 * - 각 지원자 점수가 16개의 조건 조합에 중복 저장된다.
 *
 * [정답/오답]
 * - 정답 (gpt야 고마워..)
 */


import java.util.*;

class Solution {
  Map<String, ArrayList<Integer>> map = new HashMap<>();

  //문장 조합 만드는 함수 (dfs)
  void makeAllComb(String[] temp, int depth, String str, int score){
    if (depth == 4){
      if (!map.containsKey(str)){
        map.put(str, new ArrayList<Integer>());
      }

      map.get(str).add(score);
      return;
    }

    makeAllComb(temp, depth + 1, str + temp[depth], score);
    makeAllComb(temp, depth + 1, str + "-", score);
  }

  //처음 score 이상이 나오는 위치 찾기
  int findScore(ArrayList<Integer> list, int score){
    int left = 0;
    int right = list.size();

    while (left < right){
      int mid = (left + right) / 2;

      if (list.get(mid) >= score){
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  public int[] solution(String[] info, String[] query) {
    int[] answer = new int[query.length];

    //info가 가능한 조합 만들어서 map에 넣기
    for (String i : info){

      String[] arr = i.split(" ");
      String[] temp = new String[4];
      temp[0] = arr[0];
      temp[1] = arr[1];
      temp[2] = arr[2];
      temp[3] = arr[3];

      int score = Integer.parseInt(arr[4]);
      makeAllComb(temp, 0, "", score);
    }

    //정렬 후 이분 탐색
    for (String key : map.keySet()){
      Collections.sort(map.get(key));
    }

    for (int i = 0; i < query.length; i++) {
      String q = query[i];

      q = q.replace(" and ", " ");
      String[] arr = q.split(" ");

      String key = arr[0] + arr[1] + arr[2] + arr[3];
      int score = Integer.parseInt(arr[4]);

      if (!map.containsKey(key)) {
        answer[i] = 0;
        continue;
      }

      ArrayList<Integer> list = map.get(key);

      int index = findScore(list, score);
      answer[i] = list.size() - index;
    }

    return answer;
  }
}