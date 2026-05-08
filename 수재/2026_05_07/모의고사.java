시간복잡도: O(N)
공간복잡도: O(1)

import java.util.*;

class Solution {
    public List solution(int[] answers) {
        int[] number = {0, 0, 0};

        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == num1[i % 5]) {
                number[0]++;
            }
            if (answers[i] == num2[i % 8]) {
                number[1]++;
            }
            if (answers[i] == num3[i % 10]) {
                number[2]++;
            }
        }

        int max = Arrays.stream(number).max().getAsInt();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            if (number[i] == max) {
                answer.add(i + 1);
            }
        }
        
        return answer;
    }
}

최적화

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 1. 수포자들의 패턴을 2차원 배열로 관리 (가독성 증가)
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        int[] scores = new int[3];

        // 2. 점수 계산 (if-else 대신 반복문 활용 가능)
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }

        // 3. 최댓값 찾기 (Stream 대신 Math.max 직접 사용 - 더 빠름)
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

        // 4. 최댓값 개수 파악
        int count = 0;
        for (int s : scores) if (s == maxScore) count++;

        // 5. 결과 배열 생성 및 채우기
        int[] answer = new int[count];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                answer[index++] = i + 1;
            }
        }

        return answer;
    }
}
