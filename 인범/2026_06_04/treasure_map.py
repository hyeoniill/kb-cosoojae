def solution(n, arr1, arr2):
    compositions=[]
    for n1,n2 in zip(arr1,arr2):
        temp = ""
        for i in range(0,n):
            k = 1<<i
            if k & (int(n1) | int(n2)) : temp = "#"+temp
            else : temp = " "+temp
        compositions.append(temp)
        
    return compositions