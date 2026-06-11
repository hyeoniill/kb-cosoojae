import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 종류별 최대 1가지
        // 전체 경우의 수에서 아무것도 입지 않은 경우 1개만 빼기
        // (nC0 + nC1) * .... * () - 1
        
        Map<String, List<String>> clothesMap = new HashMap<>();
        
        for (String[] cloth: clothes) {
            if (!clothesMap.containsKey(cloth[1])) {
                clothesMap.put(cloth[1], new ArrayList<String>());
            }
            clothesMap.get(cloth[1]).add(cloth[0]);
        }
        
        int answer = 1;
        
        for (String category: clothesMap.keySet()) {
            answer *= (clothesMap.get(category).size() + 1);
        }
        answer -= 1;
        
        return answer;
    }
}
