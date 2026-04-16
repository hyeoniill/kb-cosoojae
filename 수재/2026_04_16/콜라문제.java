class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // 몇 번 반복할지 모르니까 무한루프
        for (;;) {
            // 추가된 콜라 수만 더하기
            answer += (n / a) * b;
            // 빈 병을 모두 바꿨을 때 수
            // 전체 - 바꿀 수 있는 병 + 추가로 받은 병
            // n - ((n / a) * a) + ((n / a) * b)
            n = n - (n / a) * (a - b);
            // 남은 병 수가 바꿀 병 수보다 적으면 멈춤
            if (n < a) {
                break;
            }
        }

        return answer;
    }
}
