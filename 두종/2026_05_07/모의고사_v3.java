import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] cntArr = new int[3];

        for (int i = 0; i < answers.length; i++) {
            if (p1[i % 5] == answers[i]) {
                cntArr[0]++;
            }
            if (p2[i % 8] == answers[i]) {
                cntArr[1]++;
            }
            if (p3[i % 10] == answers[i]) {
                cntArr[2]++;
            }
        }

        int max = Math.max(cntArr[0], Math.max(cntArr[1], cntArr[2]));

        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (cntArr[i] == max) {
                answerList.add(i + 1);
            }
        }

        int[] answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }
}
