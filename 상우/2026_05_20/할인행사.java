import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> wantMap = new HashMap<>();  //원하는 물건과 개수 저장
        
        // 1. 원하는 물건 세팅
        for(int i = 0; i < want.length; i++){
            wantMap.put(want[i], number[i]);
        }
        
        // 2. 10일씩 검사
        for(int i = 0; i <= discount.length - 10; i++){
            
            Map<String, Integer> current = new HashMap<>();  //현재 10일 할인 상품 개수 저장
            
            // 10일 동안 할인 품목 세기
            for(int j = i; j < i + 10; j++){
                current.put(discount[j], current.getOrDefault(discount[j], 0) + 1);
            }
            
            // 원하는 상품 개수와 완전히 같으면
            if(current.equals(wantMap)){
                answer++;
            }
        }
        
        return answer;
    }
}
