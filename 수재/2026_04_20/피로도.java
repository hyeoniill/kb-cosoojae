import java.util.*;

class Solution {
    static boolean[] visited; // 방문한 곳인지 판별
    static int maxCount = 0; // 가장 큰 값 저장
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length]; // 던전 길이만큼 배열 크기

        dfs(k, 0, dungeons);

        return maxCount;
    }

	// 깊이 우선 탐색
    public static void dfs(int currentFatigue, int count, int[][] dungeons) {
        maxCount = Math.max(maxCount, count); // maxCount, count 중 큰거 저장

        for (int i = 0; i < dungeons.length; i++) {
		        // 아직 방문하지 않았고 남은 피로도로 들어갈 수 있을 때
            if (!visited[i] && currentFatigue >= dungeons[i][0]) {
                visited[i] = true; // 방문
                dfs(currentFatigue - dungeons[i][1], count + 1, dungeons); // 재귀
                visited[i] = false; // 나가기
            }
        }
    }
}
