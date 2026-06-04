import heapq

def solution(n, k, enemy):

    h = []
    answer = 0

    for i in range(0, len(enemy)):

        # 일단 넣기
        heapq.heappush(h, enemy[i])

        # k보다 많으면
        if len(h) > k:

            x = heapq.heappop(h)

            n = n - x

        # 병사 없으면 끝
        if n < 0:

            answer = i
            return answer

    answer = len(enemy)

    return answer
