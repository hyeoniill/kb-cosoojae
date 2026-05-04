/* 모의고사 No.42840 */

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        //찍는 순서
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int[] correct = {0,0,0};
        
        /*
            찍는 순서는 반복되기 때문에 나머지 연산 사용
            정답이면 correct 배열에 본인이 해당하는 위치에 ++
        */
        for(int i=0; i<answers.length; i++) {
            int answer = answers[i];
            if(answer == first[i%first.length]) correct[0]++;
            if(answer == second[i%second.length]) correct[1]++;
            if(answer == third[i%third.length]) correct[2]++;
        }
        
        //correct 배열 중에서 가장 큰 값 계산
        int max = Arrays.stream(correct).max().getAsInt();
        
        //복수 정답자가 있을 수 있기 때문에 correct의 max값에 해당하는 사람 추가
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<correct.length; i++) {
            if(correct[i] == max) result.add(i+1);
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
