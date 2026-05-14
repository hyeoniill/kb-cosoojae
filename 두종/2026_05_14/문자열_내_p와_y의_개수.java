class Solution {
    boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;
        
        //대소문자를 구분하지 않기 때문에 편의상 하나로 통일
        s = s.toLowerCase();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') pCnt++;
            else if (s.charAt(i) == 'y') yCnt++;
        }
        
        if (pCnt != yCnt) {
            return false;
        }

        return true;
    }
}
