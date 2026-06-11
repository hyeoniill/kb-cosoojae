// 뉴스 클러스터링 No.17677

import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i=0; i<str1.length()-1; i++) {
            String s = str1.substring(i, i+2).toLowerCase();
           if (s.matches("[a-z]{2}")) {
             map1.put(s, map1.getOrDefault(s, 0) + 1);
            }
        }
        for(int i=0; i<str2.length()-1; i++) {
            String s = str2.substring(i, i+2).toLowerCase();
            if (s.matches("[a-z]{2}")) {
            map2.put(s, map2.getOrDefault(s, 0)+1);
            }
        }
        
        Set<String> keys = new HashSet<>(map1.keySet());
        keys.addAll(map2.keySet());
        
        int union s = 0;
        int intersection = 0;
        
        for(String key : keys) {
            int c1 = map1.getOrDefault(key, 0);
            int c2 = map2.getOrDefault(key, 0);
            
            union += Math.max(c1, c2);
            intersection += Math.min(c1, c2);
        }
        
        if(union==0) return 65536;
        int answer = (int)((double)intersection/union * 65536);
        return answer;
    }
}
