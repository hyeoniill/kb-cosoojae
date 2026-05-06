def solution(maps):
    from collections import deque
    direction = [[1,0],[-1,0],[0,1],[0,-1]]
    N = len(maps)
    M = len(maps[0])
    queue = deque([(0,0,1)])
    visited = [[False]*M for i in range(N)]

    while queue:
        row,col,count = queue.popleft()
        visited[row][col] = True
        
        if row==N-1 and col==M-1 : return count
        
        for dr,dc in direction:
            nrow = row+dr
            ncol = col+dc
            
            if 0<=nrow<=N-1 and 0<=ncol<=M-1 and maps[nrow][ncol]==1 and not visited[nrow][ncol]:
                queue.append((nrow,ncol,count+1))
                visited[nrow][ncol]=True
        
    return -1