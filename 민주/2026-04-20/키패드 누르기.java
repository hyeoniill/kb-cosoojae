/**
 * [핵심 아이디어]
 * - 각 숫자를 좌표로 치환해서 거리를 계산
 *
 * [시간 복잡도]
 * - O(N)
 *
 * [공간 복잡도]
 * - O(N)
 *
 * [정답 / 오답]
 * - 정답
 */

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    //거리 계산해주는 함수
    int calculateDistance(int curNum, int num){
        //좌표로 치환
        int curNum_X = (curNum - 1) / 3;
        int curNum_Y = curNum - (3 * curNum_X) - 1;
        int num_X = (num - 1) / 3;
        int num_Y = num - (3 * num_X) - 1;

        return Math.abs(curNum_X - num_X) + Math.abs(curNum_Y - num_Y);
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        //* = 10, # = 12
        int leftNum = 10;
        int rightNum = 12;

        for (int num : numbers){
            // 0 = 11
            if (num == 0) num = 11;
            //1,4,7
            if (num % 3 == 1) {
                sb.append("L");
                leftNum = num;
            }
            //3,6,9
            else if (num % 3 == 0){
                sb.append("R");
                rightNum = num;
            }
            //2,5,8,0
            else {
                int leftDist = calculateDistance(leftNum, num);
                int rightDist = calculateDistance(rightNum, num);
                //1. 왼쪽이 더 가깝거나 2. 같은데 왼손잡이일 경우만 "L"
                if (leftDist < rightDist || (leftDist == rightDist && hand.equals("left"))){
                    sb.append("L");
                    leftNum = num;
                }
                //이외에는 "R"
                else{
                    sb.append("R");
                    rightNum = num;
                }
            }
        }

        return sb.toString();
    }
}
