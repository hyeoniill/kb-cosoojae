def solution(s):
    answer = []
    flag = True
    for item in s:
        if item == " ":
            flag=True
            answer.append(item)
            continue
        if flag:
            item = item.upper()
            answer.append(item)
            flag=False
        else :
            item = item.lower()
            answer.append(item)
            
            
    return ''.join(answer)