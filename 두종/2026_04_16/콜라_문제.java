class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int currentNum = n;

        while (currentNum >= a) {
            answer += (currentNum / a) * b;
            // 현재 병 수를 업데이트할 때 remainder에 해당하는 값을 추가
            currentNum = (currentNum / a) * b + currentNum % a;
        }

        return answer;
    }
}