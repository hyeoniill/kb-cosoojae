/*
몸무게정렬
양끝에서 시작
같이 탈수 있으면 둘 다 이동
아니면 무거운 사람만 태우기
*/
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;   // 가장 가벼운 사람
        int right = people.length - 1;  // 가장 무거운 사람
        int boat = 0;
        
        while(left <= right){
            // 둘이 같이 탈 수 있으면
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            } else{ // 무거운 사람 혼자
                right--;
            }
            boat++; // 보트 하나 사용
        }
        return boat;
    }
}
