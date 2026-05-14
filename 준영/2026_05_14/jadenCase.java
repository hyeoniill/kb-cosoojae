class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 && arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char) (arr[i] - 32);
            } else if (i != 0 && arr[i - 1] == ' ' && arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = (char) (arr[i] - 32);
            }
        }
        answer = new String(arr);
        return answer;
    }
}
