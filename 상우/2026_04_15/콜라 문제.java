class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int newCola = (n / a) * b; // 새로 받은 콜라
            answer += newCola;        // 총 콜라 누적
            
            n = (n % a) + newCola;    // 남은 병 + 새로 생긴 빈 병
        }
        return answer;
    }
}
