class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        int[] score = new int[3];
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int max = 0;

        // 몇 문제를 맞췄는지
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) {
                score[0]++;
            }
            if (answers[i] == p2[i % p2.length]) {
                score[1]++;
            }
            if (answers[i] == p3[i % p3.length]) {
                score[2]++;
            }
        }
        for (int i = 0; i < score.length; i++) {       // 최댓값 구하기
            if (score[i] > max) {
                max = score[i];
            }
        }
        int count = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                count++;
            }
        }
        answer = new int[count];
        int c = 0;
        for (int i = 0; i < score.length; i++) {
            if (score[i] == max) {
                answer[c] = i + 1;
                c++;
            }
        }
        return answer;
    }
}
