import java.util.ArrayList;
import java.util.List;


class Solution {
    
    public static void solve(int n,List<Integer> list){
    if(n==1){
        return;
    }
    if(n%2 == 0){
        list.add(n/2);
        solve(n/2,list);
    }
    else{
        list.add(3*n+1);
        solve(3*n+1,list);
    }
    }
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        solve(n,list);
        
        int[] answer = new int[list.size()];
        for(int i =0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
