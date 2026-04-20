import static java.lang.Math.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[] lH = {0, 3}; // 열, 행
        int[] rH = {2, 3};

        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7){
                answer += "L";
                lH[0] = 0;
                lH[1] = num/3;
            } else if (num == 3 || num == 6 || num == 9) {
                answer += "R";
                rH[0] = 2;
                rH[1] = (num-1)/3;
            } else {
                if (num == 0) num = 11;
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
                else if ((1-lH[0]) + abs(lH[1]-(num/3)) < (rH[0]-1) + abs(rH[1]-(num/3))) {
                    answer += "L";
                    lH[0] = 1;
                    lH[1] = num/3;
                } else {
                    answer += "R";
                    rH[0] = 1;
                    rH[1] = num/3;
                }
            }
        }
        
        return answer;
    }
