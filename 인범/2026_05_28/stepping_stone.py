def solution(distance, rocks, n):
    
    # 거리를 기준으로 이분 탐색을 해야함
    rocks.append(distance)
    rocks.sort()
    
    # 최소 돌 간 거리는 1, 최대 거리는 distance
    start = 1
    end = distance
    answer = 0
    
    # 
    while start <= end:
        removed = 0
        prev = 0
        mid = (start+end)//2
        # 돌간 거리를 mid로 계산한다.
        # prev는 rock 사이의 거리를 계산하기 위한 이전 돌 위치
        # 모든 돌에 대해서 탐색을 수행한다
        
        for rock in rocks:
            # 목표 거리 mid 보다 작다면, 해당 rock을 삭제한다.
            # rock을 삭제하면 prev는 그대로 유지된다
            if rock-prev < mid:
                removed += 1  
            # 목표 거리 mid보다 두 돌간 거리가 커서 현재 rock이 다음 돌과 비교할 돌이 된다
            else : prev = rock
            
            # 돌 제거한 개수가 n을 초과하면 해당 목표길이 (mid)는 불가능한 목표이므로 빠르게 탈출
            if removed > n : break
        
        # 목표길이 mid를 성공시키면서, 제거한 돌의 개수가 n보다 작다면, 더 많은 돌을 제거해서 거리를 늘릴 가능성이 있다.
        # 그러므로 목표 길이 mid를 늘리기 위해서 start를 갱신한다.
        if removed <= n : 
            answer = mid
            start = mid+1
        # mid의 길이가 너무 길어서 제거할 개수가 n개로는 부족하다. 목표길이 mid를 줄이기 위해서 end를 갱신한다.
        else:
            end = mid-1
            
        
    return answer