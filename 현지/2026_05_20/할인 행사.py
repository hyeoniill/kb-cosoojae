def solution(want, number, discount):

    answer = 0

    for i in range(len(discount)-9):

        arr = discount[i:i+10]

        ok = True

        for j in range(len(want)):

            if arr.count(want[j]) != number[j]:
                ok = False
                break

        if ok == True:
            answer += 1

    return answer
