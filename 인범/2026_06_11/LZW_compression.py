def solution(msg):
    from collections import defaultdict
    answer = []
    mydict = defaultdict(int)
    for i in range(1,27):
        curr = chr(ord('A')+i-1)
        mydict[curr] = i
    
    w = 0
    c = w+1
    curr = ""
    lastIdx= 27
    while c <= len(msg):
        curr = msg[w:c]
        hit = mydict.get(curr)
        
        if hit :
            c+=1
            continue
        else:
            mydict[curr]=lastIdx
            answer.append(mydict.get(curr[:-1]))
            w=c-1
            c=w+1
            lastIdx+=1
    
    answer.append(mydict.get(curr))
    return answer