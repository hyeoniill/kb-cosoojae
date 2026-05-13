# 처음부터 끝까지 모든 패턴을 탐색한다고 하면? n^2
# s의 길이는 1000이니까, 1,000,000 이라서 통과 가능?
# 그런데, 패턴을 어떻게 인식하지?
# 첫번째에서부터 패턴이 나와야하니까, 검증조건은 맨 처음만 찍히면 됨.
# 슬라이드 윈도우를 만들어서 찍기? 근데 최적이라고 장담할 수 있나?
# 일단 슬라이드윈도우 만들기


def solution(s):
    answer = []
    if len(s)==1: return 1
    
    for length in range(1,len(s)//2 +1):
        # length는 슬라이딩 윈도우 길이
        pattern = []
        pat = ""
        i = 0
        while i<len(s):
            window = s[i:i+length]
            count = 1
            j = i + length
            
            while j < len(s) and s[j:j+length] == window:
                count += 1
                j += length
            
            if count >1 : 
                pat = str(count) + ''.join(window)
                pattern.append(pat)
            else :
                pat = ''.join(window)
                pattern.append(pat)
            i=j
        answer.append(''.join(pattern))

    return min(map(len,answer))


"""
착각했던점 : 단위로 자른다는게, 등분을 한다는건데 그냥 2개 단위로 찾아본다고 생각했음.
그래서 슬라이딩 윈도우를 만들고 한칸씩 밀어서 패턴을 찾아야되는건줄 알고 헤맸음.
그냥 등분하는 것이라서, 등분했을 때 압축되는 정도를 파악하면 됨.

헷갈렸던점 : 윈도우를 생성하고 이동시킬 때, for문으로 인덱스를 관리하려고 하니까 머리가 터질것 같았음.
생각해보면, for문을 사용할 땐 idx로 접근하는게 위험함(인덱스값은 for문에 의해서만 결정해야 함)
그래서 반복문을 while로 사용해야한다는걸 GPT가 가르쳐줌.
그 후에, 지피티가 문제를 꿰뚫어봐서 정답을 알아버림.

엣지케이스 : s 길이가 1인 경우를 계산하지 않았음. 해당 while 조건문에서는 len(s)==1인 경우에는 런타임에러가 발생하게 됨. 그래서 맨 처음에 탈출하는 코드를 만들었음. 실제로는 반복문 코드 내에서 관리하는게 더 좋은 코드일 것 같음.
"""