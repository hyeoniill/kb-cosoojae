class Solution {
    public int solution(int n) {
        int MOD = 1234567;
        
        int prev2 = 0;  //F(0) 두 칸 전 피보나치
        int prev1 = 1;  //F(1) 한 칸 전 피보나치
        int cur = 0;    //지금 구할 값
        
        for(int i = 2; i <= n; i++){
            cur = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = cur;
        }
        return cur;
    }
}
