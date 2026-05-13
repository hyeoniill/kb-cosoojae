/**
 * [핵심 아이디어]
 * - dfs
 *
 * [시간 복잡도]
 * - O(N^2)
 *
 * [공간 복잡도]
 * - O(N)
 */

class Solution {
    boolean[] visited;
    int result;
    public void dfs (int i, int[][] computers) {

        visited[i] = true;
        for (int j = 0; j < computers.length; j++){
            if (!visited[j] && computers[i][j] == 1){
                dfs(j, computers);
            }
        }
    }
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        result = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, computers);
                result++;
            }
        }
        return result;
    }
}
