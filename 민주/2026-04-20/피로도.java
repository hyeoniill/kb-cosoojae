/**
 * [핵심 아이디어]
 * - 던전 최대 8개 -> 모든 순서로 던전을 돌아도 가능
 * - dfs 와 백트래킹을 활용
 *
 * [시간 복잡도]
 * - O(N!)
 *
 * [공간 복잡도]
 * - O(N)
 *
 * [정답 / 오답]
 * - 정답
 */
class Solution {

    boolean[] visited;

    int goDungeons(int e, int[][] dungeons, int count){

        int max = count;

        for (int i = 0; i < dungeons.length; i++){
            if (!visited[i] && e >= dungeons[i][0]) {
                visited[i] = true;
                max = Math.max(max,goDungeons(e - dungeons[i][1], dungeons, count + 1));
                visited[i] = false;
            }
        }
        return max;
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        return goDungeons(k, dungeons, 0);
    }
}
