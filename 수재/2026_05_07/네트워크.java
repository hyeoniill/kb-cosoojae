시간복잡도: O(N^2)
공간복잡도: O(N)

import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n]; // 방문 확인용

        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터라면 새로운 네트워크 시작!
            if (!visited[i]) {
                answer++;
                bfs(i, n, computers, visited);
            }
        }
        
        return answer;
    }
    public void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next = 0; next < n; next++) {
                // 1. 연결되어 있고 (computers[current][next] == 1)
                // 2. 자기 자신이 아니며 (current != next - 사실 1번 조건에 포함됨)
                // 3. 아직 방문하지 않았다면
                if (computers[current][next] == 1 && !visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
