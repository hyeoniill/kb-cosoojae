// 시간복잡도: O(n)
// 공간복잡도: O(n)

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; // s의 길이만큼 배열 선언
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (!map.containsKey(c)) { // 처음 나온 알파벳일 때
                answer[i] = -1;
            } else { // 이전에 나온 알파벳일 때
                answer[i] = i - map.get(c);
            }
            map.put(c, i);
        }
        
        return answer;
    }
}

최적화--------------------------------------------------

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; // s의 길이만큼 배열 선언
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            // 위에 if문이 간략하므로 삼항식으로 표현
            answer[i] = map.containsKey(c) ? i - map.get(c) : -1;
            
            map.put(c, i);
        }
        
        return answer;
    }
}
