# 일단 인코더로 라벨링을 만드렁
# 이후에 딕셔너리(해시맵)에 튜플을 이용해서 Key로 만들고, Score는 Value로서 list 에 저장해
# 여기서 이분탐색을 써야할 수도 있어.

# Value에 Score를 저장하는 방식을 이진트리 형식으로 구현하면 될것 같아.
# 아니면 그냥 Sort() 하고 이분 탐색을 해도 괜찮겠지.

# 3. 정렬 후 이진탐색 해보기


def solution(info, query):
    from collections import defaultdict
    from itertools import combinations
    
    table = defaultdict(list)
    answer = []
    
    for record in info:
        attributes = [item for item in record.split()]
        keys= attributes[:4]
        score= int(attributes[4])
        
        for size in range(5):
            for comb in combinations(range(4),size):
                temp = keys[:]
                
                for col in comb:
                    temp[col] = "-"
                    
                key = tuple(item for item in temp)
                table[key].append(score) # 튜플을 키로 사용하기
                
    # print(list(table.items()))
    
    # 모든 테이블의 scores 를 정렬해버림. O(N*logN)
    # 이러면 query를 처리할 때마다 O(logN) 으로 이진 탐색이 가능해짐
    for key in table:
        table[key].sort()
    
    
    for q in query:
        lang, job, carrer, last = map(str.strip,q.split("and"))
        food, score = last.split()
        score = int(score)
    
        key = tuple([lang, job, carrer, food])
        scores = table[key]
        
        start=0
        end = len(scores)

        
        while start < end:
            mid = (end+start)//2
            
            if score <= scores[mid] :
                end = mid
                mid = (end+start)//2
            else : 
                start = mid+1
        answer.append(len(scores)-start)
        
    return answer