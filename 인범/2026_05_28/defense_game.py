def solution(n, k, enemy):
    import heapq as hq
    nodes=[]
    answer = 0
    
    for idx, em in enumerate(enemy):
        hq.heappush(nodes,(-em,idx)) # 일단 인덱스를 기록함. 최대 힙으로 구현
        if n >= em :
            n -= em # 값을 빼줌
        else: # 리스트 순회를 더이상 할 수 없는 경우
            while n < em : # 까방권을 최대한 써야 함
                if k == 0 : return answer # 더 이상 까방권을 쓸 수 없음
                val, index = hq.heappop(nodes)
                # n의 값을 늘려줌. 
                # 파이썬은 최소힙이라서 - 값으로 가져왔으니 빼줘야지만 값이 커짐
                n -= val                     
                k -= 1 # 까방권을 하나 씀    
            # 탈출 성공
            n -= em # 다시 값을 빼줘야 함
        answer += 1 # 한 칸 전진했음
    return answer