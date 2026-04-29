class Solution {
    public int[] solution(String s) {
        char[] arr = s.toCharArray();   // 문자열을 문자 배열로 만들기
        int[] answer = new int[arr.length];
        int index;
        // 현재 위치를 기준으로 해서
        // 맨 앞에서 현재 위치의 앞까지 값을 비교
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {   // 맨 앞은 무조건 -1
                answer[0] = -1;
                continue;
            }
            index = -1;
            for (int j = 0; j < i; j++) {   // 위치를 갱신
                if (arr[i] == arr[j]) {
                    index = j;
                }
            }
            if (index == -1) {          // 같은 문자가 없으면 -1
                answer[i] = -1;
            } else {
                answer[i] = i - index;  // 현재 위치에서 얼마나 앞에 있는지 계산
            }
        }
        return answer;
    }
}
