def solution(want, number, discount):
    from collections import Counter

    target = dict(zip(want, number))
    answer = 0

    window = Counter(discount[:10])

    if window == target:
        answer += 1

    for i in range(10, len(discount)):
        out_item = discount[i - 10]
        in_item = discount[i]

        window[out_item] -= 1
        if window[out_item] == 0:
            del window[out_item]

        window[in_item] += 1

        if window == target:
            answer += 1

    return answer