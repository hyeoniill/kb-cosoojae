def solution(s):
    from collections import defaultdict
    mydict = defaultdict(list)
    answer = []
    for idx, item in enumerate(s):
        mydict[item].append(idx)
        if len(mydict[item])>=2:
            answer.append(mydict[item][-1]-mydict[item][-2])
        else:
            answer.append(-1)
    
    

    return answer