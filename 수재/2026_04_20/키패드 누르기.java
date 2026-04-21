import static java.lang.Math.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] lH = {0, 3}; // 열, 행
        int[] rH = {2, 3};

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7){
                answer += "L"; // 출력에 왼손추가
                lH[0] = 0; // 1,4,7은 무조건 0번 열
                lH[1] = num/3; // 몫으로 0,1,2 표시
            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                rH[0] = 2;
                rH[1] = (num-1)/3;
            } else {
                if (num == 0) num = 11; // 0인경우 11로 변경
                // 맨해튼 거리 가 같을 때
                if ((1-lH[0]) + abs(lH[1]-(num/3)) == (rH[0]-1) + abs(rH[1]-(num/3))) {
                    if (hand.equals("left")) {
                        answer += "L";
                        lH[0] = 1;
                        lH[1] = num/3;
                    } else {
                        answer += "R";
                        rH[0] = 1;
                        rH[1] = num/3;
                    }
                }
                // 왼손이 더 가까울 때
                else if ((1-lH[0]) + abs(lH[1]-(num/3)) < (rH[0]-1) + abs(rH[1]-(num/3))) {
                    answer += "L";
                    lH[0] = 1;
                    lH[1] = num/3;
                } else { // 오른손이 더 가까울 때
                    answer += "R";
                    rH[0] = 1;
                    rH[1] = num/3;
                }
            }
        }
        
        return answer;
    }
}

// 최적화 --------------------------------------------------

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
                if (num == 0) num = 11; // 0일 때 11로 변환
                int[] mDis = {1, num/3}; // 가운데 줄 위치
                int lDis = getDistance(lPos, mDis); // 왼손, 가운데 수 맨해튼거리
                int rDis = getDistance(rPos, mDis);

                if (lDis < rDis) move = 'L'; // 왼손이 가까우면 L
                else if (lDis > rDis) move = 'R';
                else move = hand.equals("left") ? 'L' : 'R'; // 거리 같으면 손잡이로
            }

            answer += move;
            // 움직인 손이 왼쪽이면 왼손 좌표를 조정
            int[] currentHand = (move == 'L') ? lPos : rPos;
            currentHand[0] = (num+2) % 3;
            // 오른손은 3,6,9라서 몫이 1,2,3이 됨, 그래서 1씩 뺌
            if (move == 'R') num -= 1;
            currentHand[1] = num / 3;
        }
        
        return answer;
    }
}
