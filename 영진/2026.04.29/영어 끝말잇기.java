import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};

        Set<String> s = new HashSet<>();
      
        //Set에 나왔던 단어들 모두 저장
        s.add(words[0]);
        for(int i =1; i<words.length; i++) {
            if(words[i].length() == 1){ //
                return new int[] {i%n+1,i/n+1};
            }
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                return new int[] {i%n+1,i/n+1}; //전 단어 끝문자와 현재 단어 앞문자 다르면
            }
            if(!s.add(words[i])){ // add에 실패 -> 이미 있는 경우
                return new int[] {i%n+1,i/n+1};
            }
        }
   
        return answer;
    }
}
