class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toLowerCase().toCharArray();
        int cnt_p = 0;
        int cnt_y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'p') {
                cnt_p++;
            } else if (arr[i] == 'y') {
                cnt_y++;
            }
        }
        if (cnt_p != cnt_y) {
            answer = false;
        }

        return answer;
    }
}
