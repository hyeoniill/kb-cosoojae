def solution(cacheSize, cities):
    import heapq as hq
    from collections import defaultdict
    mydict=defaultdict(list)
    answer = 0
    
    for city in cities:
        city=city.lower()
        
        if cacheSize == 0 : 
            answer +=5
            continue
        if city not in mydict:
            answer+=5
            
            if len(mydict.keys())>=cacheSize:
                    maxi = max(mydict.values())
                    delkey= None
                    for key,val in mydict.items():
                        if val==maxi : 
                            delkey=key
                            break
                    mydict.pop(delkey)

            mydict[city]=0
            
            for key in mydict.keys():
                mydict[key]+=1
        else:
            answer += 1
            mydict[city] = 0
            
            for key in mydict.keys():
                mydict[key]+=1
                
    return answer