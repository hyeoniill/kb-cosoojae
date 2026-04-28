// 시간복잡도: O(L)
// 공간복잡도: O(L)

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Map<String, Boolean> map = new HashMap<>();

        map.put(words[0], true); // 첫번째 단어 HashMap에 삽입

        for(int i = 1; i < words.length; i++){
            // 단어의 끝부분이 뒷단어의 앞부분과 다른지, 이미 나왔던 단어인지(HashMap에 들어있는)
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || map.containsKey(words[i])){
                answer[0] = ((i) % n) + 1; // n번째 사람
                answer[1] = ((i) / n) + 1; // n바퀴
                break;
            }
            map.put(words[i], true);
        }

        return answer;
    }
}

최적화--------------------------------------------------

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> hSet = new HashSet<>(); // 단일값이므로 HashSet사용

        hSet.add(words[0]); // 첫번째 단어 HashSet에 삽입

        for(int i = 1; i < words.length; i++){
            // hSet.add를 사용하여 삽입과 판별을 같이함
            if (words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0) || !hSet.add(words[i])){
                answer[0] = (i % n) + 1; // n번째 사람
                answer[1] = (i / n) + 1; // n바퀴
                break;
            }
        }

        return answer;
    }
}
