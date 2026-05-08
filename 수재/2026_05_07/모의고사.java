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
