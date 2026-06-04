
def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        # arr1의 숫자를 이진수 배열로
        num1 = arr1[i]
        bin1 = []
        for _ in range(n):
            bin1.append(num1 % 2)
            num1 = num1 // 2
        bin1.reverse() # 거꾸로 들어가서 뒤집어줘야 함
        
        # arr2의 숫자를 이진수 배열로
        num2 = arr2[i]
        bin2 = []
        for _ in range(n):
            bin2.append(num2 % 2)
            num2 = num2 // 2
        bin2.reverse()
        
        # 두 지도를 겹치면서 '#'이랑 공백으로 한 줄
        row_str = ""
        for j in range(n):
            # 지도1이 벽1이거나 지도2가 벽1이면 전체 지도도 벽 #
            if bin1[j] == 1 or bin2[j] == 1:
                row_str += "#"
            else:
                row_str += " "
                
        answer.append(row_str)
        
    return answer
