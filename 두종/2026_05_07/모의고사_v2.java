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

        // 1. 최대값 찾기
        int maxCnt = Math.max(cntArr[0], Math.max(cntArr[1], cntArr[2]));

        // 2. 동점자 수 세기
        int dupCnt = 0;
        for (int s : cntArr) {
            if (s == maxCnt) {
                dupCnt++;
            }
        }

        // 3. 결과 배열 채우기
        int[] result = new int[dupCnt];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if (cntArr[i] == maxCnt) {
                result[index++] = i + 1;
            }
        }

        return result;
    }
}