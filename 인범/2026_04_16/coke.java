class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        // 일단 받을 수 있는 최소한의 조건이 n/a의 몫이 1 이상이어야 함.
        while(n/a >0){
            answer += (n/a)*b;
            n = n%a + (n/a)*b;
            // n의 값은 끝날때까지 지속해야함.
        }
        return answer;
    }
}