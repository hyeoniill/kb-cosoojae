def solution(scoville, K):
    import heapq as hq
    hq.heapify(scoville)
    answer = 0
    
    while scoville:
        if scoville[0] < K and len(scoville)>=2:
            lowest = hq.heappop(scoville)
            lower = hq.heappop(scoville)
            hq.heappush(scoville, lowest + lower*2)
            answer += 1
        elif scoville[0] >= K: return answer
        else : return -1
    

    return answer