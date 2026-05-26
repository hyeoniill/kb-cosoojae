import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 이분 탐색을 사용하기 위해서 하나의 정렬된 배열을 만들어야 한다.
        // GPT가 말하길, 한 사람이 어디에 들어갈지를 계산하지 말라고 하신다.
        // 다시 말해, 특정 시간에서 처리할 수 있는 인원 수를 계산하라는 것. Parametric Search!
        // 한 번 만들어보자

        
        // 가장 긴 기간이 걸리는 창구에서 받는 건 고려할 필요가 없다.
        // N명을 처리하기 위해 고려할 최대 시간은, 가장 작은 기간이 걸리는 창구에서 전부 받아버리는 경우임
        int minTime = times[0];
        for (int time : times) {
            if (time < minTime) {
                minTime = time;
            }
        }
        
        // 최소 시간은 1, 최대 시간은 n명을 혼자 처리하는 경우.
        long start = 1;
        long end = (long) n * minTime;

        while (start < end) {
            long mid = (start + end) / 2;

            // mid 시간 동안 심사관들이 처리할 수 있는 총 인원 수를 세주자.
            long passed = 0;
            for (int time : times) {
                passed += mid / time;
            }
            
            // mid 시간 안에 n명 이상 처리할 수 있다면, 시간이 충분하다는 뜻이므로 더 작은 시간을 탐색
            if (passed >= n) end = mid; 
            
            // mid 시간 안에 n명을 처리하지 못한다면, 시간이 부족하다는 뜻이므로 더 큰 시간을 탐색
            else start = mid + 1;
        }

        return start;
    }
}