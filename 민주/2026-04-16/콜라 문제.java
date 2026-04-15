class Solution {
    public int solution(int a, int b, int n) {
        int result = 0;
        while(n >= a){
            int get = (n / a) * b;
            n = n % a + get;
            result += get;
        }
        return result;
    }
}
