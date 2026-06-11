import java.util.*;

class Solution {
  public int[] solution(String msg) {

    Map<String, Integer> map = new HashMap<>();
    List<Integer> answer = new ArrayList<>();

    char a = 'A';
    for (int i = 0; i < 26; i++){
      map.put(String.valueOf((char)(a + i)), i + 1);
    }

    int endIdx = 27;
    char[] msgArr = msg.toCharArray();
    int start = 0;
    int maxLength = 1;

    while (start < msg.length()){

      int tempSize = maxLength;

      while(tempSize > 0){

        if (start + tempSize <= msg.length() &&
            map.containsKey(msg.substring(start, start + tempSize))){

          answer.add(map.get(msg.substring(start, start + tempSize)));

          if (start + tempSize + 1 <= msg.length()){
            map.put(msg.substring(start, start + tempSize + 1), endIdx++);
            maxLength++;
          }
          start += tempSize;
          break;
        }

        else {
          tempSize--;
        }
      }
    }
    return answer.stream()
        .mapToInt(Integer::intValue)
        .toArray();
  }
}
