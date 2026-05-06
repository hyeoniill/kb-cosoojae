def solution(n, computers):
    from collections import deque
    visited = [False]*n
    answer = 0
    
    def dfs(idx,link):
        visited[idx]=True
        for i in range(len(link)):
            if link[i] == 1 and not visited[i]:
                dfs(i,computers[i])
    
    for i in range(n):
        if visited[i] == False:
            answer += 1
            dfs(i,computers[i])
        
    
    return answer