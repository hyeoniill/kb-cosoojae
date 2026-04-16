class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // a : 빈 병 -> b : 새로운 병 // n : 가지고 있는 빈 병의 수
        int new_bottle;     // 새 병 수
        int empty_bottle;   // 비어있는 병 수
        int total_bottle = n;
        while (total_bottle >= a) {
            new_bottle = total_bottle / a * b;    // 빈 병을 바꾸고 받은 새 병
            empty_bottle = total_bottle % a;         // 빈 병을 바꾸고 남은 빈 병
            answer += new_bottle;      // 새로 받은 병의 총 개수
            total_bottle = new_bottle + empty_bottle;   // 빈 병과 새 병의 수를 합쳐 탈출 기준을 정한다.
        }

        return answer;
    }
}
