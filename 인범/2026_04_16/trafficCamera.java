import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        System.out.println(Arrays.deepToString(routes));
        int temp = -99999;
        for (int i=0; i<routes.length; i++){
            int start = routes[i][0];
            int end = routes[i][1];
            if (temp < start){
                temp = end;
                answer += 1;
            }
        }
        
        
        return answer;
    }
}