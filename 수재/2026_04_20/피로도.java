import java.util.*;

class Solution {
    static boolean[] visited;
    static int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        dfs(k, 0, dungeons);

        return maxCount;
    }

    public static void dfs(int currentFatigue, int count, int[][] dungeons) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true;
                dfs(currentFatigue - dungeons[i][1], count + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}
