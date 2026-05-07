class Solution {
    public void dfs(int idx, int[] link, boolean[] visited, int[][]computers){
        visited[idx] = true;
        for(int i=0; i<link.length; i++){
            if(!visited[i] && link[i]==1){
                dfs(i,computers[i],visited,computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i,computers[i],visited,computers);
                answer++;
            }
        }
        
        return answer;
    }
}