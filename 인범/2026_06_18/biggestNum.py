def solution(numbers):
    result = [(str(num)*3, str(num)) for num in numbers]
    result.sort(reverse=True)
    
    # print(result)
    answer=''
    for comp, num in result:
        answer += num
    
    return answer if answer[0] != "0" else "0"