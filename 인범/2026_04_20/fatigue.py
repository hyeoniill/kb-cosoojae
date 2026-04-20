def solution(k, dungeons):
    import itertools
    
    answer = -1
    fact = list(itertools.permutations(dungeons,len(dungeons)))
    
    for item in fact:
        temp_k = k
        temp_d = 0
        for dun in item:
            if temp_k >= dun[0]:
                temp_d += 1
                temp_k -= dun[1]
        if temp_d> answer : answer = temp_d
    
    
    return answer