def solution(cacheSize, cities):
    answer = 0
    cache = []
    
    if cacheSize == 0:
        return len(cities) * 5
        
    for city in cities:
        city = city.lower() # 일단 소문자로 통일
        
        if city in cache:
            answer += 1
            cache.remove(city) # 있던 자리에서 지우고
            cache.append(city) # 맨 뒤로 새로 보냄
            
        else:
            answer += 5
            if len(cache) >= cacheSize:
                cache.pop(0)   # 제일 오래된 맨 앞놈 추방
            cache.append(city) # 맨 뒤에 추가
            
    return answer
