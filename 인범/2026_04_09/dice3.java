import java.util.*;
import java.util.HashMap;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = new int[]{a,b,c,d};
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for (int item : arr){
            map.put(item, map.getOrDefault(item,0) + 1);
        }
        
        List<Map.Entry<Integer,Integer>> tups = new ArrayList<>(map.entrySet());
        tups.sort((x,y) -> y.getValue() - x.getValue());
        
        int cond1 = tups.get(0).getValue();
        int cond2 = tups.size();
        
        if (cond1==4){
            return 1111*tups.get(0).getKey();
        }
        if (cond1==3){
            int p = tups.get(0).getKey();
            int q = tups.get(1).getKey();
            return (int) Math.pow(10*p + q, 2);
        }
        if (cond1==2 && cond2 == 2){
            int p = tups.get(0).getKey();
            int q = tups.get(1).getKey();
            return (p+q) * Math.abs(p-q);
        }
        if (cond1==2 && cond2==3){
            int p = tups.get(0).getKey();
            int q = tups.get(1).getKey();
            int r = tups.get(2).getKey();
            return q*r;
        }
        else {
            int minVal = 999;
            for (Map.Entry<Integer,Integer> entry : tups){
                minVal = Math.min(minVal, entry.getKey());
            }
            return minVal;
        }
    }
}