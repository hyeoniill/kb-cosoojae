import java.util.*;


class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int ans_f=0;
        int ans_s=0;
        int ans_t=0;
        int f_idx = 0;
        int s_idx = 0;
        int t_idx = 0;
        
        for(int i=0; i<answers.length; i++){
            f_idx = i%first.length;
            s_idx = i%second.length;
            t_idx = i%third.length;
            if(answers[i] == first[f_idx]){ans_f++;}
            if(answers[i] == second[s_idx]){ans_s++;}
            if(answers[i] == third[t_idx]){ans_t++;}
        }
        
        int maxi = Math.max(Math.max(ans_f,ans_s),ans_t);
        ArrayList<Integer> temp = new ArrayList<>();
        if(maxi == ans_f){temp.add(1);}
        if(maxi == ans_s){temp.add(2);}
        if(maxi == ans_t){temp.add(3);}
        
        int[] answer = new int[temp.size()];
        for(int i=0; i<temp.size(); i++){
            answer[i] = temp.get(i);
        }
        return answer;
    }
}