import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        //다중집합이기 때문에 Map을 사용해서 등장횟수도 함께 저장

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for (int i = 0; i < str1.length() - 1; i++) {
            String curS = str1.substring(i, i + 2);
            char c0 = curS.charAt(0);
            char c1 = curS.charAt(1);
            if (c0 >= 'a' && c0 <= 'z' && c1 >= 'a' && c1 <= 'z') {
                map1.put(curS, map1.getOrDefault(curS, 0) + 1);
            }
        }
        
        for (int i = 0; i < str2.length() - 1; i++) {
            String curS = str2.substring(i, i + 2);
            char c0 = curS.charAt(0);
            char c1 = curS.charAt(1);
            if (c0 >= 'a' && c0 <= 'z' && c1 >= 'a' && c1 <= 'z') {
                map2.put(curS, map2.getOrDefault(curS, 0) + 1);
            }
        }
        
        int interCnt = 0;
        int unionCnt = 0;
        
        for (String key: map1.keySet()) {
            if (map2.containsKey(key)) {
                interCnt += Math.min(map1.get(key), map2.get(key));
                unionCnt += Math.max(map1.get(key), map2.get(key));
            }
            else {
                unionCnt += map1.get(key);
            }
        }
        
        for (String key: map2.keySet()) {
            if (!map1.containsKey(key)) {
                unionCnt += map2.get(key);
            }
        }
        
        if (interCnt == 0 && unionCnt == 0) {
            return 65536;
        }
        
        return interCnt * 65536 / unionCnt;
    }
}
