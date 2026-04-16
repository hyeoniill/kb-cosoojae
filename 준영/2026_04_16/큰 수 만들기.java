class Solution {
    public String solution(String number, int k) {
        String answer;
        StringBuilder sb = new StringBuilder();
        char[] num = number.toCharArray();  // 숫자형 문자열을 배열로 바꾸기
        int total = num.length - k;             // 숫자형 문자열의 자릿수
        int limit = 0; // 제한 걸어두기 (첫번째 자릿수는 끝에서 total-1를 제외하고 선택하는 방식으로)
        int left = total;       // 남은 자릿수
        char max_num;     // 최댓값
        int max_index = 0;
        while (true) {
            max_num = '0';
            for (int i = limit; i < num.length; i++) {
                if (num[i] > max_num) {              // 최댓값을 찾을 때마다 갱신
                    max_num = num[i];
                    max_index = i;                      //최댓값일 떄 index 저장
                }
                if (i + left == num.length) {        // 더 이상 움직이면 안되는 조건에 도달하면
                    sb.append(max_num);  // 찾은 최댓값을 집어넣는다.
                    left--;
                    if (max_index < i) {
                        limit = max_index + 1;
                    } else {
                        limit = i + 1;
                    }
                    break;
                }
            }
            if (left == 0) {
                break;
            }
        }
        answer = sb.toString();
        return answer;
    }
}
