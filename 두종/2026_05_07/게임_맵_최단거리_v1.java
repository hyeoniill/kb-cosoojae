import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[][] board;
    static int n, m;

    public int solution(int[][] maps) {
        // 최단거리 구하기, 미로 탐색 -> BFS
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        board = maps;

        bfs(0, 0);

        if (board[n-1][m-1] == 1) {
            return -1;
        }

        return board[n-1][m-1];
    }

    public static void bfs(int startX, int startY) {
        Queue<int[]> myQueue = new ArrayDeque<>();
        visited[startX][startY] = true;
        myQueue.offer(new int[] {startX, startY});

        while (!myQueue.isEmpty()) {
            int[] curPos = myQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curPos[0] + dx[i];
                int ny = curPos[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && board[nx][ny] == 1) {
                    board[nx][ny] = board[curPos[0]][curPos[1]] + 1;
                    visited[nx][ny] = true;
                    myQueue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}