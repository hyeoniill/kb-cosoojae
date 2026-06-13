import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 오름차순 정렬
        int n = citations.length;
        int answer = 0;
        
        for(int i = 0; i < n; i++){
            int h = n - i;  // 현재 논문 이상으로 인용된 논문 개수
            // h편 이상이 h번 이상 인용
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}
