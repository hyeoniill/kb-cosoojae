import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int N = maps.length;
        int M = maps[0].length;
        boolean[][] visited = new boolean[N][M];
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{0,0,1});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.pollFirst();
            int row = curr[0];
            int col = curr[1];
            int count = curr[2];
            
            if(row==N-1 && col==M-1){return count;}
            
            for(int[] d : direction){
                int nr = row+d[0];
                int nc = col+d[1];
                
                if(nr<0 || nr>=N || nc<0 || nc>=M){continue;}
                if(visited[nr][nc]){continue;}
                if(maps[nr][nc] == 0) {continue;}
                
                q.addLast(new int[]{nr,nc,count+1});
                visited[nr][nc] = true;
            }
        }
        
        
        return answer;
    }
}