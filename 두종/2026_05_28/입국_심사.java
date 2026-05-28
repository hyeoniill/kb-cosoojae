import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // n이 최대 10억... -> O(n) 은 사용 불가
        // 매번 판단하는 것이 안된다?
        // 시간별로 최대로 처리할 수 있는 사람수 저장하기? -> 이것도 한 명 심사 시간이 최대 10억
        // dp로 풀고 싶지만 안될 것 같다..
        // times의 각 요소별 배수에 해당되는 숫자들이 다음 사람이 거쳐갈 곳
        // 0, 7, 14, 21, 28, ...
        // 0, 10, 20, 30, ...
        // 최대 시간 = n * times[i] = 10^9 * 10^9 = 10^18 : long 자료형의 범위 안에 있다
        // 이분 탐색으로 조건을 만족하는 lower bound 찾기
        
        Arrays.sort(times);
        
        long l = 0;
        long r = (long)n * times[times.length-1];
        
        while (l < r) {
            long mid = (l + r) / 2;
            long sum = 0;
            
            for (int i = 0; i < times.length; i++) {
                sum += (mid / times[i]);
            }
            
            if (sum < n) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        
        return r;
    }
}
