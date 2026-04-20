class Solution {
		// 맨해튼 거리 구하기
    public static int getDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 열, 행
        int[] lPos = {0, 3}; // 왼손 위치
        int[] rPos = {2, 3}; // 오른손 위치
        char move; // 움직일 손

        for (int num : numbers) {
            if (num%3 == 1){ // 1, 4, 7
                move = 'L';
            } else if (num != 0 && num%3 == 0) { // 3, 6, 9
                move = 'R';
            } else {
                if (num == 0) num = 11;
                int[] mDis = {1, num/3}; // 가운데 줄 위치
                int lDis = getDistance(lPos, mDis);
                int rDis = getDistance(rPos, mDis);

                if (lDis < rDis) move = 'L';
                else if (lDis > rDis) move = 'R';
                else move = hand.equals("left") ? 'L' : 'R';
            }

            answer += move;
            int[] currentHand = (move == 'L') ? lPos : rPos;
            currentHand[0] = (num+2) % 3;
            if (move == 'R') num -= 1;
            currentHand[1] = num / 3;
        }
        
        return answer;
    }
}
