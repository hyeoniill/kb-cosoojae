import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int curr=1, cyc=1;
        int index = 0;
        boolean flag = true;
        Set<String> set = new HashSet<>();
        
        while(flag){
            String word = words[index];
            if(index==0){
                set.add(word);
                curr++;
                index++;
            }
            else{ // 첫 단어 이후
                String before = words[index-1];
                if(before.charAt(before.length()-1) != word.charAt(0)){
                    flag = false;
                }
                else if(!set.add(word)){ // 이미 잇는 경우 boolean false return
                    flag = false;
                }
                else{ // set 에 자료 추가 완료
                    curr++;
                    index++;
                }
            }
            if(curr>n){
                curr=1;
                cyc++;
            }
            if(index>=words.length){
                flag=false;
            }
        }
        if(!(index>=words.length)){
        int[] answer = {curr,cyc};
        return answer;
        }
        else{
            int[] answer = {0,0};
            return answer;
        }
    }
}