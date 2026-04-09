import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        
        for(int i = 0; i<=n; i++){
            if (i>=list.size()){
                list.add((list.get(i-2) + list.get(i-1)) % 1234567);
            }
        }
        answer = list.get(n);
        
        return answer;
    }
}