def solution(numbers, hand):
    from collections import defaultdict
    isright = hand == "right"
    answer = []
    currL = [3,0]
    currR = [3,2]

    mydict = defaultdict(list)
    left = {1,4,7}
    right = {3,6,9}
    mid = {2,5,8,0}
    
    for i in range(1,10):
        row = (i-1)//3
        col = (i-1)%3
        mydict[i] = [row,col]
    mydict[0] = [3,1]
    
    for number in numbers:
        if number in left : 
            answer.append("L")
            currL = mydict[number]
        if number in right :
            answer.append("R")
            currR = mydict[number]
        if number in mid:
            ld = abs(mydict[number][0]-currL[0]) + abs(mydict[number][1]-currL[1])
            rd = abs(mydict[number][0]-currR[0]) + abs(mydict[number][1]-currR[1])
            if ld > rd : 
                answer.append("R")
                currR=mydict[number]
            elif ld < rd :
                answer.append("L")
                currL=mydict[number]
            else:
                if isright:
                    answer.append("R")
                    currR=mydict[number]
                else:
                    answer.append("L")
                    currL=mydict[number]
                
    
    print(list(mydict.items()))
    return ''.join(answer)