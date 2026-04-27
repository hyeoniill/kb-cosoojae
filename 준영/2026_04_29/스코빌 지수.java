// 처음 코드 -> 시간 초과
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        boolean pass = true;

        List<Integer> sort_arr = new ArrayList<>();
        for (int s : scoville) {
            sort_arr.add(s);
        }
        for (int s : sort_arr) { // 전체 스코빌이 K를 넘지 않는 경우 (처음부터 조건을 만족할 수 있으므로)
            if (s < K) {
                pass = false;
            }
        }
        // 정렬부터
        sort_arr.sort(Comparator.naturalOrder());
        while (sort_arr.size() >= 2 && !pass) {
            answer++;
            int s1 = sort_arr.remove(0);
            int s2 = sort_arr.remove(0);
            int n = s1 + s2 * 2;
            for (int i = 0; i < sort_arr.size(); i++) {
                if (n < sort_arr.get(i)) {
                    sort_arr.add(i, n);
                    break;
                }
            }
            pass = true;
            for (int s : sort_arr) {
                if (s < K) {
                    pass = false;
                    break;
                }
            }
        }
        if (!pass) {
            answer = -1;
        }
        return answer;
    }
}

// 시간 초과 해결 코드

import java.util.PriorityQueue;

class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 우선순위 큐 사용
        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.peek() < K) {    // 맨 앞에 있는 수가 제일 작은데 K를 넘지 않는다면 반복해서 스코빌 지수 계산
            if (pq.size() < 2) {    // 더 이상 계산 X
                answer = -1;
                break;              // 해결 안됨으로 처리
            }
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.add(s1 + s2 * 2);
            answer++;
        }

        return answer;
    }
}
