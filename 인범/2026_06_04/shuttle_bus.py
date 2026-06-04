def stranswer(answer):
    return str((answer//60)//10)+str((answer//60)%10) +":"+ str((answer%60)//10) + str((answer%60)%10)   

def tonum(string):
    hour,minute = map(int,string.split(":"))
    return hour*60 + minute

def solution(n, t, m, timetable):
    from collections import deque
    timetable.sort()
    timetable = deque(timetable)
    answer = 0
    last_bus=540+(n-1)*t
    
    i = 1
    while i<=n :
        curr_bus = 540+(i-1)*t
        time = 0
        counter = 0
        for j in range(m):
            if timetable: 
                time= tonum(timetable[0])
                if time <= curr_bus : 
                    counter +=1
                    timetable.popleft()
                else : break
                
            else : return stranswer(last_bus)
        if i==n and counter == m:
            return stranswer(time-1)
        if i==n and counter != m : 
            return stranswer(last_bus)
        i+=1
    
    
     
    return stranswer(last_bus)