class Solution {
    public int solution(String s) {
        int N = s.length();
        int answer = N;

        for (int len = 1; len <= N / 2; len++) {
            answer = Math.min(answer, getCompressedLen(s, len));
        }

        return answer;
    }

    private int getCompressedLen(String s, int len) {
        int N = s.length();
        int compressedLen = 0;
        String prevS = s.substring(0, len);
        int count = 1;
        int index = len;

        //처음으로 len만큼 자른 이후부터, 이전 문자열과 현재 문자열 비교
        for (; index <= N - len; index += len) {
            String curS = s.substring(index, index + len);
            
            if (curS.equals(prevS)) {
                count++;
            } else { //현재 문자열이 이전문자열과 다른 경우
                compressedLen += getPatternLen(count, prevS);
                count = 1;
                prevS = curS;
            }
        }

        //반복문에서 처리되지 않은 마지막 문자열(prevS) 처리
        compressedLen += getPatternLen(count, prevS);

        //len으로 자른 마지막 문자열 이후에 여전히 남아 있는 문자열이 있다면
        compressedLen += (N - index);

        return compressedLen;
    }

    private int getPatternLen(int count, String pattern) {
        int patternLen = pattern.length();
        
        if (count > 1) {
            patternLen += String.valueOf(count).length();
        }
        return patternLen;
    }
}
