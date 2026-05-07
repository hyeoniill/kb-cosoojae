import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] newmap = new int[102][102];
        boolean[][] visited = new boolean[102][102];
        int[][] newrect = new int[rectangle.length][4];
        int charX=characterX*2;
        int charY=characterY*2;
        int ix=itemX*2;
        int iy=itemY*2;
        
        for(int i=0; i<rectangle.length; i++){
            newrect[i][0] = rectangle[i][0]*2;
            newrect[i][1] = rectangle[i][1]*2;
            newrect[i][2] = rectangle[i][2]*2;
            newrect[i][3] = rectangle[i][3]*2;
        }
        
        for(int[] rect : newrect){
            int lx=rect[0];
            int ly=rect[1];
            int rx=rect[2];
            int ry=rect[3];
            
            for(int i=lx; i<=rx; i++){
                for(int j=ly; j<=ry; j++){
                    newmap[i][j] = 1;
                }
            }
        }
        for(int[] rect : newrect){
            int lx=rect[0];
            int ly=rect[1];
            int rx=rect[2];
            int ry=rect[3];
        
            for(int i=lx+1; i<rx; i++){
                for(int j=ly+1; j<ry; j++){
                    newmap[i][j] = 0;
                }
            }
        }
        
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{charX,charY,0});
        
        while(!q.isEmpty()){
            int[] curr = q.pollFirst();
            int row = curr[0];
            int col = curr[1];
            int count = curr[2];
            
            if(row==ix && col==iy){return count/2;}
            
            for(int[] dir : direction){
                int nr = row+dir[0];
                int nc = col+dir[1];
                
                if(nr<0 || nr>=102 || nc<0 || nc>=102){continue;}
                if(visited[nr][nc]){continue;}
                if(newmap[nr][nc] == 1){
                    q.addLast(new int[]{nr,nc,count+1});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return -1;
    }
}