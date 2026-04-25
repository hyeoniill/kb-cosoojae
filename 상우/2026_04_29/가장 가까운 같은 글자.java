import java.util.*;

// 각 문자 마지막 등장 위치를 저장해두고 거리 계산하기
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()]; //결과 배열
        
        //key : 문자, value : 마지막 위치
        HashMap<Character, Integer> map = new HashMap<>();
        
        //문자열 순회
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // 현재 문자
            
            if (!map.containsKey(c)) {  //이전에 나온 적이 없는 경우, containsKey(key) : map에서 키가 있는지 확인하는 함수
                answer[i] = -1;
            } 
            else {  //이전에 나온 적이 있는 경우
                answer[i] = i - map.get(c); //현재 위치 - 이전 위치, get(key) : key에 매핑된 값(value)을 가져오는 함수 
            }
            
            map.put(c, i); //현재 위치를 최신으로 갱신
        }
        
        return answer;
    }
}
