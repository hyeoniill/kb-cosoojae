def solution(answers):
    def first(idx):
        return idx%5
    def second(idx):
        if idx%2==1:
            return 2
        else:
            idx = idx%8
            if idx == 2 : return 1
            if idx == 4 : return 3
            if idx == 6 : return 4
            if idx == 0 : return 0
    def third(idx):
        idx=idx%10
        if idx in (1,2): return 3
        if idx in (3,4): return 1
        if idx in (5,6): return 2
        if idx in (7,8): return 4
        if idx in (0,9): return 0
            
    f,s,t=0,0,0
    
    for idx, ans in enumerate(answers):
        ff= first(idx+1)
        ss = second(idx+1)
        tt = third(idx+1)
        if ans == 5 : ans=0 
        
        if ans == ff : f+=1
        if ans == ss : s+=1
        if ans == tt : t+=1
    
    maxi = max(f,s,t)

    answer= [idx+1 for idx, item in enumerate([f,s,t]) if maxi==item]
    return answer