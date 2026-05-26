# 이분 탐색을 사용하기 위해서 하나의 정렬된 배열을 만들어야 한다.
# GPT가 말하길, 한 사람이 어디에 들어갈지를 계산하지 말라고 하신다.
# 다시 말해, 특정 시간에서 처리할 수 있는 인원 수를 계산하라는 것. Parametric Search!
# 한 번 만들어보자


def solution(n, times):
    # N명을 처리하기 위한 최대 시간은 가장 작은 기간이 걸리는 창구에서 전부 받아버리는 경우다.
    start = 1
    end = n*min(times)
    
    while start < end:
        mid = (end+start)//2
        passed = sum(mid//time for time in times)
        
        
        if passed >= n:
            end = mid
            mid = (end+start)//2
        else:
            start = mid+1
            
    return start