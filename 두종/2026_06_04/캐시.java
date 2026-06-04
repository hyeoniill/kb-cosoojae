import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 대소문자 구분X -> toLowerCase() 로 일괄 처리 후 판단
        // List에 도시들을 저장 -> 이미 있다면 제거 후 마지막 위치에 추가
        // 일치하면 +1, 일치하는게 없으면 +5
        // 마지막 도시에 도착할 때까지 반복
        
        if (cacheSize == 0) {
            return 5 * cities.length;
        }
        
        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }
        
        List<String> cacheList = new ArrayList<>();
        int answer = 0;
        
        for (String city: cities) {
            if (cacheList.contains(city)) {
                answer += 1;
                cacheList.remove(city);
                cacheList.add(city);
            }
            else {
                answer += 5;
                if (cacheList.size() == cacheSize) {
                    cacheList.remove(cacheList.get(0));
                }
                cacheList.add(city);
            }
        }

        return answer;
    }
}
