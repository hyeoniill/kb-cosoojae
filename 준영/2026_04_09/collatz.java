import java.util.*;
class Solution {
    public int[] solution(int n) {
        List<Integer> coll = new ArrayList<>();
        
        while(true){
            if (n == 1){
                coll.add(n);
                break;
            }
            else if (n % 2 == 0){
                coll.add(n);
                n /= 2;
            }
            else{
                coll.add(n);
                n = n * 3 + 1;
            }
        }
        int[] answer = new int[coll.size()];
        for (int i = 0; i < coll.size(); i++){
            answer[i] = coll.get(i);
        }
        return answer;
    }
}
