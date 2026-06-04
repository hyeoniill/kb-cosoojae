def solution(sequence, k):

    s = 0
    e = 0

    total = sequence[0]

    answer = [0, len(sequence)-1]

    while True:

        if total < k:

            e += 1

            if e >= len(sequence):
                break

            total = total + sequence[e]

        elif total > k:

            total = total - sequence[s]

            s += 1

        else:

            if (answer[1] - answer[0]) > (e - s):
                answer = [s, e]

            total -= sequence[s]

            s = s + 1

    return answer
