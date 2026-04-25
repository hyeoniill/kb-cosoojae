import java.util.*;

// 중복 검사하기, 끝말잇기 규칙, 틀린 사람 번호 + 차례 게산
class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();  //set은 중복 제거가 목적
        set.add(words[0]);  //첫 단어는 무조건 통과
        
        for(int i = 1; i < words.length; i++){  //두 번째 단어부터 검사
            String prev = words[i - 1]; //이전 단어
            String current = words[i];  //현재 단어
            
            //끝말잇기 규칙 위반했는지 확인
            //이전 단어의 마지막 문자 != 현재 단어의 첫 문자
            if(prev.charAt(prev.length() - 1) != current.charAt(0)){
                int person = (i % n) + 1;   //틀린 사람 번호 = (i % n) + 1
                int turn = (i / n) + 1; //차례 = (i / n) + 1

                return new int[]{person, turn};
            }
            
            //중복 단어 사용했는지 확인
            if(set.contains(current)) {
                int person = (i % n) + 1;
                int turn = (i / n) + 1;

                return new int[]{person, turn};
            }
            set.add(current);   //현재 단어 저장
        }
        return new int[]{0, 0}; //끝까지 탈락자 없으면 [0, 0] 리턴
    }
}
