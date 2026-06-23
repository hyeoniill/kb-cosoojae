import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;
        
        Arrays.sort(citations);  //오름차순 정렬
        
        for (int i = n - 1; i >= 0; i--) { //h = n - i
            if (citations[i] >= n - i) {
                answer = n - i; //계속 갱신
            } 
            else { 
                // 정렬이 되어 있기 때문에 조건이 한 번 깨지면 더 큰 h 불가
                break;
            }
        }
        
        return answer;
    }
}
