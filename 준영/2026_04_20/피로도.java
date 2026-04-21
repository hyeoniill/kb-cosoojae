class Solution {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        boolean[] visited = new boolean[dungeons.length]; // 던전을 방문했는지 확인
        int count = 0;
        answer = dungeon(k, dungeons, visited, count);

        return answer;
    }

    public int dungeon(int k, int[][] dungeons, boolean[] visited, int count) {
        int maxCount = count; // 최대 방문 횟수

        for (int i = 0; i < dungeons.length; i++) {
            // 방문하지 않은 던전이고 피로도 조건을 충족했을 때
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true; // 던전을 방문

                // 재귀 호출 사용 : 피로도 소모하고, count 1 증가시켜서 다음 던전 탐색
                // 여기서 나온 결과와 현재 maxCount 중 큰 값을 저장
                int result = dungeon(k - dungeons[i][1], dungeons, visited, count + 1);
                maxCount = Math.max(maxCount, result);

                visited[i] = false; // 백트래킹 (방문 해제 : 다른 순서로 탐색하기 위해)
            }
        }
        return maxCount;
    }
}
