def solution(sequence, k):
    answer = [0, len(sequence)-1]
    start = 0
    end = 0
    cumm = sequence[end]
    while start < len(sequence) and end < len(sequence):
        nlength= end - start

        if cumm == k:
            mini = answer[1]-answer[0]
            if nlength < mini : answer = [start,end]
            cumm -= sequence[start]
            start += 1
            
        elif cumm < k : 
            end += 1
            if end < len(sequence) : cumm += sequence[end]
            
        else :
            cumm -= sequence[start]
            start += 1
                
        
    return answer