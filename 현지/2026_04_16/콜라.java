class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
       while (n >= a) {
           int newcok = (n/a) * b; //내가 받은 콜라 개수
           int lefcok = n%a; //나에게 남아있는 병의 개수
           n = newcok+lefcok;//내가 받은거 + 남은거 > 내가 줄 콜라?
           answer += newcok;
       } return answer;
    }
}
