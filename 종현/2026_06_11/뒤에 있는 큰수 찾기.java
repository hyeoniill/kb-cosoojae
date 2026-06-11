// 뒤에 있는 큰 수 찾기 No.154539

import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        for(int i=0; i<numbers.length; i++) {
            for(int j=i; j<answer.length; j++) {
                if(numbers[i] < numbers[j]) {
                    answer[i] = numbers[j];
                    break;
                }
            }
        }
        return answer;
    }
}
