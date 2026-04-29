import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int targetPerson = 0;
        int targetIndex = 0;
        
        // 현재 단어를 트래킹할 변수
        String curWord = words[0];
        
        // 이전 단어의 마지막 글자를 트래킹할 변수
        char lastC = curWord.charAt(curWord.length() - 1);
        
        // 단어 중복 여부를 확인하기 위해 Set 활용
        Set<String> wordSet = new HashSet<>();
        wordSet.add(curWord);
        
        for (int i = 1; i < words.length; i++) {
            curWord = words[i];
            
            // 종료조건: 현재 단어의 첫 글자가 이전 단어의 마지막 글자와 다르거나, 단어 중복
            if (curWord.charAt(0) != lastC || wordSet.contains(curWord)) {
                targetPerson = i % n + 1;
                targetIndex = i / n + 1;
                break;
            }
            
            // 틀리지 않았다면 마지막 글자 업데이트, wordSet에 단어 추가
            lastC = curWord.charAt(curWord.length() - 1);
            wordSet.add(curWord);
        }
        
        int[] answer = {targetPerson, targetIndex};
        return answer;
    }
}
