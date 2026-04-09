import java.util.*;

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        
        int temp = n;
        while (temp != 1){
            if(temp%2==0){
                list.add(temp);
                temp=temp/2;
            } else{
                list.add(temp);
                temp = 3*temp+1;
            }
        }
        
        int[] answer = new int[list.size()+1];
        for(int i=0; i<list.size()+1; i++){
            if(i<list.size()){
                answer[i] = list.get(i);    
            } else {
                answer[i] = 1;
            }
            
        }
        return answer;
        
    }
}