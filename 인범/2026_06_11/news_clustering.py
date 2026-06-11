def solution(str1, str2):
    from collections import defaultdict
    import math
    str1dict = defaultdict(int)
    str2dict = defaultdict(int)
    answer = 0
    
    str1 = str1.lower()
    str2 = str2.lower()
    
    i = 0
    j = i+2
    while j<=len(str1):
        st = str1[i:j]
        if st.isalpha():
            str1dict[st]+=1
        i+=1
        j=i+2
    
    i=0
    j=i+2
    while j<=len(str2):
        st = str2[i:j]
        if st.isalpha():
            str2dict[st]+=1
        i+=1
        j=i+2
    
    # print(str1dict)
    # print(str2dict)
    
    keypool = set()
    for key in str1dict.keys():
        keypool.add(key)
    for key in str2dict.keys():
        keypool.add(key)
    
    
    union = 0
    intersection = 0
    
    for key in keypool:
        A=str1dict.get(key)
        B=str2dict.get(key)
        if A and B :
            maxi = max(A,B)
            mini = min(A,B)
            union += maxi
            intersection += mini
        elif A : 
            union += A
        else :
            union += B
    
    # print(union)
    # print(intersection)
    return math.floor((intersection/union) * 65536) if union else 65536