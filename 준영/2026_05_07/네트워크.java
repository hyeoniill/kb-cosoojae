class Solution {
    public static void dfs(int now, int[][] computers, boolean[] visited, int n) {
        visited[now] = true;    // 현재 위치 방문체크하고

        // 방문하지 않았고 자기 자신이 아니면서 다른 컴퓨터와 연결됐다면
        // 방문처리하고 다음 컴퓨터로 이동
        for (int i = 0; i < n; i++) {
            if (!visited[i] && i != now && computers[now][i] == 1) {
                visited[i] = true;
                dfs(i, computers, visited, n);
            }
        }

    }

    public static int solution(int n, int[][] computers) {
        int network = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {       // 컴퓨터 0부터 시작해서
            if (visited[i] == false) {      // 연결되지 않은 (방문하지 않은) 컴퓨터가 있다면
                network++;
                dfs(i, computers, visited, n);  // 네트워크 연결 시작하고 dfs 시작.
            }
        }

        return network;
    }
}
