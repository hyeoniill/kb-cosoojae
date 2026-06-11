import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 사전 - Map으로 일단 저장
        
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        StringBuilder sb = new StringBuilder(msg);
        
        int index = 1; //색인번호
        for (char c = 'A'; c <= 'Z'; c++) {
            dictionary.put(String.valueOf(c), index++);
        }

        outer: while (sb.length() > 0) {
            int curNum = 0;
            String curS = "";
            for (int i = 0; i < sb.length(); i++) {
                curS = sb.substring(0, i + 1); //w+c
                if (!dictionary.containsKey(curS)) {
                    answerList.add(curNum);
                    sb.delete(0, i);
                    break;
                } 
                else {
                    curNum = dictionary.get(curS);
                }
                
                if (i == sb.length() - 1) {
                    answerList.add(curNum);
                    break outer;
                }
            }
            
            dictionary.put(curS, index++);
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
