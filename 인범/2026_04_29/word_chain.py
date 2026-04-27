def solution(n, words):
    from collections import defaultdict
    mydict = defaultdict(int)
    answer = []
    mywords = set()
    curr = 1
    passing = True
    
    for idx, word in enumerate(words):
        if idx>0 and word[0] != words[idx-1][-1]:
            # print(word[0], words[idx-1][-1])
            mydict[curr] += 1
            passing = False
            break
        if word not in mywords:
            # print(word)
            mywords.add(word)
            mydict[curr] += 1
            if curr == n : curr = 1
            else : curr += 1
        else:
            # print(word)
            mydict[curr] += 1
            passing = False
            break;
    
    if not passing :
        answer.append(curr)
        answer.append(mydict[curr])
        return answer
    else : return [0,0]