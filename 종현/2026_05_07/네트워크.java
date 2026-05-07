/* 네트워크 No.43162 */

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int count = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        
        for(int start = 0; start<n; start++) {
            if(visited[start] == true) continue;
            
            count++;
            visited[start] = true;
            queue.offer(start);
            
            while(!queue.isEmpty()) {
                int current = queue.poll();
                for(int i=0; i<n; i++) {
                    if(computers[current][i] == 1 && !visited[i]) {
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }
        return count;
    }
}
