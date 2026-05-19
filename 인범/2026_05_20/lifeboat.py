def solution(people, limit):
    people.sort()
    boats = [0]*len(people)
    
    i = 0
    j = len(people)
    while i < j:
        if people[i] + people[j-i-1] > limit : 
            boats[j-i-1] = 1
            j -= 1
        else :
            if boats[i] != 0 : 
                i+=1
                continue
            if i == j-i-1 : boats[i]=1
            else:
                boats[i]=0.5
                boats[j-i-1]=0.5
            i+= 1
        #print("지금 boats: ", boats)
    return sum(boats)