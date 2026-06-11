def solution(numbers):
    answer = [-1]*len(numbers)
    stack = []
    
    for idx, number in enumerate(numbers):
        if not stack :
            answer[idx]=-1
            stack.append(idx)    
        else :
            while stack:
                lastIdx = stack[-1]
                last = numbers[lastIdx]
                if last < number:
                    answer[lastIdx] = number
                    stack.pop()
                else :
                    break
            stack.append(idx)
            
    return answer