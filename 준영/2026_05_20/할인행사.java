import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 원하는 제품과 수량을 해시맵에 저장
        Map<String, Integer> wishMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wishMap.put(want[i], number[i]);
        }
        
        // 10일 할인 품목
        Map<String, Integer> discountMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }
        
        // 10일 구간이 조건과 맞는지 확인
        if (isMatch(wishMap, discountMap)) {
            answer++;
        }
        for (int i = 10; i < discount.length; i++) {
            String removeItem = discount[i - 10];
            if (discountMap.get(removeItem) == 1) {
                discountMap.remove(removeItem);
            } else {
                discountMap.put(removeItem, discountMap.get(removeItem) - 1);
            }
            // 새로운 날짜 품목 추가
            String addItem = discount[i];
            discountMap.put(addItem, discountMap.getOrDefault(addItem, 0) + 1);
            // 조건이 맞는지 확인
            if (isMatch(wishMap, discountMap)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 두 해시맵이 일치하는지 비교하는 함수
    private boolean isMatch(Map<String, Integer> wishMap, Map<String, Integer> discountMap) {
        for (String key : wishMap.keySet()) {
            // 원하는 물건이 없거나, 수량이 부족하면 false
            if (!discountMap.containsKey(key) || discountMap.get(key) < wishMap.get(key)) {
                return false;
            }
        }
        return true;
    }
}
