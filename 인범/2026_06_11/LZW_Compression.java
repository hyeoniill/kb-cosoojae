import java.util.*;

class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        
        for(char c = 'A'; c<='Z'; c++){
            String key = String.valueOf(c);
            int value = c-'A'+1;
            map.put(key,value);
        }
        
        int w=0;
        int c=w+1;
        String curr = "";
        int lastIdx=27;
        
        while(c<=msg.length()){
            curr = msg.substring(w,c);
            
            if(map.containsKey(curr)){
                c++;
                continue;
            } else {
                map.put(curr,lastIdx);
                
                String prev= curr.substring(0,curr.length() - 1);
                answer.add(map.get(prev));
                
                w=c-1;
                c=w+1;
                lastIdx++;
            }
        }
        answer.add(map.get(curr));
        
        int[] result = new int[answer.size()];
        
        for (int i=0; i<answer.size(); i++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
}