from bisect import bisect_left

def solution(info, query):

    answer = []

    dic = {}

    # info 돌기
    for i in range(len(info)):

        temp = info[i].split()

        lang = temp[0]
        job = temp[1]
        career = temp[2]
        food = temp[3]
        score = int(temp[4])

        arr1 = [lang, '-']
        arr2 = [job, '-']
        arr3 = [career, '-']
        arr4 = [food, '-']

        # 16개 경우 만들기
        for a in arr1:
            for b in arr2:
                for c in arr3:
                    for d in arr4:

                        key = a + b + c + d

                        if key not in dic:
                            dic[key] = []

                        dic[key].append(score)

    # 정렬
    for k in dic:
        dic[k].sort()

    # query 처리
    for q in query:

        q = q.replace(" and ", " ")

        temp2 = q.split()

        q1 = temp2[0]
        q2 = temp2[1]
        q3 = temp2[2]
        q4 = temp2[3]
        qscore = int(temp2[4])

        find = q1 + q2 + q3 + q4

        # 없는 경우
        if find not in dic:

            answer.append(0)

        else:

            score_list = dic[find]

            # 이분탐색
            idx = bisect_left(score_list, qscore)

            cnt = len(score_list) - idx

            answer.append(cnt)

    return answer
