class Solution {
    public String solution(String number, int k) {
        StringBuffer sb = new StringBuffer();

        int sLen = number.length();
        int toFindCnt = sLen - k;

        int maxDigit = -1;
        int maxIndex = -1;

        while (toFindCnt > 0) {
            maxDigit = -1;
            int tempIndex = 0;

            for (int i = sLen - toFindCnt; i > maxIndex; i--) {
                int digit = number.charAt(i) - '0';

                if (digit >= maxDigit) {
                    maxDigit = digit;
                    tempIndex = i;
                }
            }
            maxIndex = tempIndex;
            sb.append(maxDigit);
            toFindCnt--;
        }

        return sb.toString();
    }
}