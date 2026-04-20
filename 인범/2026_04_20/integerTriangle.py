def solution(triangle):
    answer = 0
    mytri = [[0 for i in range(len(tri))] for tri in triangle]
    
    
    for idx,tri in enumerate(triangle):
        for idx2, item in enumerate(tri):
            if idx > 0:
                if idx2 == 0 :
                    mytri[idx][idx2] = item + mytri[idx-1][idx2]
                elif idx2 == len(tri)-1 :
                    mytri[idx][idx2] = item + mytri[idx-1][idx2-1]
                else:
                    curr_l = item + mytri[idx-1][idx2-1]
                    curr_r = item + mytri[idx-1][idx2]
                    mytri[idx][idx2] = max(curr_l,curr_r)
            else:
                # idx == 0 인 상태
                mytri[idx][idx2] = triangle[idx][idx2]
            
            
    return max(mytri[-1])