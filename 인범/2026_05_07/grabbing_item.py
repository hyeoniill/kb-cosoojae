def solution(rectangle, characterX, characterY, itemX, itemY):
    from collections import deque
    maxi = 0
    for rect in rectangle:
        maxi = max(maxi,max(rect))
    mymap = [[0]*(maxi*2 +1) for _ in range(maxi*2+1)]
    visited = [[False]*(maxi*2 +1) for _ in range(maxi*2+1)]
    
    for rect in rectangle:
        lx,ly,rx,ry = rect
        for i in range(lx*2,rx*2+1):
            for j in range(ly*2,ry*2+1):
                mymap[i][j] = 1
    
    for rect in rectangle:
        lx,ly,rx,ry = rect
        for i in range(lx*2 +1, rx*2):
            for j in range(ly*2 +1, ry*2):
                mymap[i][j] = 0
    
    queue = deque([(characterX*2,characterY*2,0)])
    visited[characterX*2][characterY*2] = True
    direction = [[1,0],[-1,0],[0,1],[0,-1]]
    
    while queue:
        curr_x, curr_y, count = queue.popleft()
        
        if curr_x==itemX*2 and curr_y==itemY*2 : return count//2
        
        for dx,dy in direction:
            nx= curr_x+dx
            ny= curr_y+dy
            
            if 0<=nx<=maxi*2 and 0<=ny<=maxi*2 and mymap[nx][ny]==1 and not visited[nx][ny]:
                queue.append((nx,ny,count+1))
                visited[nx][ny]=True
        
    
    
    
    return -1