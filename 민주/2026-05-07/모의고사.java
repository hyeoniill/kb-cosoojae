/**
 * [핵심 아이디어]
 * - 답을 순회하면서 각자 채점
 *
 * [시간 복잡도]
 * - O(N)
 *
 * [공간 복잡도]
 * - O(1)
 *
 * [정답 / 오답]
 * - 정답
 */

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++){
            int a = answers[i];
            if (a == answer1[i%5]){
                score[0]++;
            }
            if (a == answer2[i%8]){
                score[1]++;
            }
            if (a == answer3[i%10]){
                score[2]++;
            }
        }

//         int max = Integer.MIN_VALUE;

//         for (int i = 0; i < 3; i++){
//             if (score[i] > max) {
//                 max = score[i];
//             }
//         }
        //for문 안쓰고 Math.max로 최댓값 찾기
        int max = Math.max(score[0], Math.max(score[1], score[2]));

        
        List<Integer> tempResult = new ArrayList<>();
        for (int i = 0; i < 3; i++){
            if (score[i] == max) {
                tempResult.add(i + 1);
            }
        }

        int[] result = new int[tempResult.size()];
        for (int i = 0; i < result.length; i++){
            result[i] = tempResult.get(i);
        }

        return result;
    }
}
