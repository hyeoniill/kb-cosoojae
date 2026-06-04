import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long minTime = 1;
        long maxTime = (long) n * times[times.length -1];
        
        while (minTime <= maxTime){
            long midTime = minTime + (maxTime - minTime) / (long)2;
            long sum = 0;
            for (int t : times){
                sum += midTime / t;
                if (sum >= n){
                    break;
                }
            }
            if (sum >= n){
                answer = midTime;
                maxTime = midTime-1;
            }
            else{
                minTime = midTime+1;
            }

        }
        
        
        return answer;
    }
}
