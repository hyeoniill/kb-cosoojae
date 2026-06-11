def solution(clothes):
    from collections import defaultdict
    mydict=defaultdict(list)
    
    for item in clothes:
        cloth,typ = item
        mydict[typ].append(cloth)
    
    total = 1
    for val in mydict.values():
        total *= (len(val)+1)
    
    
    return total-1