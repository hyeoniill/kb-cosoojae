class Solution {
    static int[][] dungeonInfo;
    static boolean[] visited;
    static int hp;
    static int maxDepth;
    
    public int solution(int k, int[][] dungeons) {
        // 탐험해야할 던전 개수가 많지 않다 (8!) -> 다 해보기
        int answer = -1;
        
        dungeonInfo = dungeons;
        maxDepth = 0;
        
        for (int i = 0; i < dungeons.length; i++) {
            // 탐색 시작 위치별 static 변수들 초기화
            visited = new boolean[dungeons.length];
            hp = k;
            dfs(i, 0);
        }
        
        answer = maxDepth;
        
        return answer;
    }
    
    public static void dfs(int startNode, int depth) {
        visited[startNode] = true;
        depth++;
        hp -= dungeonInfo[startNode][1];
        if (depth > maxDepth) maxDepth = depth;
        
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (hp >= dungeonInfo[i][0]) {
                    dfs(i, depth);
                    // 이후에 재탐색을 할 때 한번 사용했던 노드 다시 사용 가능
                    visited[i] = false;
                    hp += dungeonInfo[i][1];
                }
            }
        }
    }
}
