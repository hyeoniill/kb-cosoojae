import java.util.*;

class Solution {
    public int[] solution(String s) {
        char[] cArr = s.toCharArray();
        int[] answer = new int[cArr.length];
        
        // a - z 의 최신 인덱스를 저장하는 배열 생성
        int[] indexArr = new int['z' - 'a' + 1];
        
        // 0이 아닌 다른 값으로 초기화 (인덱스 배열에 0을 저장하는 경우가 있으므로)
        Arrays.fill(indexArr, -100);
        
        for (int i = 0; i < cArr.length; i++) {
            int curPos = cArr[i] - 'a';
            
            if (indexArr[curPos] == -100) {
                answer[i] = -1;
                indexArr[curPos] = i;
            } else {
                answer[i] = i - indexArr[curPos];
                indexArr[curPos] = i;
            }
        }
            
        return answer;
    }
}
