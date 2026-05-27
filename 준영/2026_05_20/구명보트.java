import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);    // 오름차순 정렬
        
        int start = 0;
        int end = people.length - 1;
        
        // start와 end가 교차하면 종료
        while (start <= end) {
            // 가장 무거운 사람 + 가장 가벼운 사람 <= limit 이면 패스
            if (people[start] + people[end] <= limit) {
                start++;    // 다음
            }
            end--;
            
            boat++;
        }
        
        return boat;
    }
}
