class Solution {
    static int max = 0;          // 지금까지 탐험한 최대 던전 수
    static boolean[] visited;    // 각 던전 방문 여부 체크

    public int solution(int k, int[][] dungeons) {
        // 던전 개수만큼 방문 배열 생성
        visited = new boolean[dungeons.length];

        // DFS 시작
        // k: 현재 피로도
        // 0: 현재까지 탐험한 던전 수
        dfs(k, dungeons, 0);

        // 최대 탐험 수 반환
        return max;
    }

    // DFS 함수
    public void dfs(int fatigue, int[][] dungeons, int count) {
        // 현재까지 탐험한 개수와 기존 최대값 비교해서 갱신
        max = Math.max(max, count);

        // 모든 던전을 하나씩 확인
        for (int i = 0; i < dungeons.length; i++) {

            // 조건:
            // 1. 아직 방문하지 않은 던전
            // 2. 현재 피로도로 입장 가능한 던전
            if (!visited[i] && fatigue >= dungeons[i][0]) {

                // 현재 던전 방문 처리
                visited[i] = true;

                // 다음 단계로 이동 (재귀 호출)
                // 피로도: 현재 피로도 - 소모 피로도
                // count + 1: 던전 하나 더 탐험
                dfs(fatigue - dungeons[i][1], dungeons, count + 1);

                // 🔥 백트래킹 (핵심)
                // 다른 경우의 수를 탐색하기 위해 방문 상태를 되돌림
                visited[i] = false;
            }
        }
    }
}
