import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] cloth : clothes){
            String item = cloth[0];
            String type = cloth[1];
            map.put(type, map.getOrDefault(type,0) + 1);
        }
        
        for(Integer amount : map.values()){
            answer *= (amount +1);
        }
        
        // System.out.println("Map : " + map);
        return answer -1;
    }
}