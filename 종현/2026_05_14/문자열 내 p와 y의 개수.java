/* 문자열 내 p와 y의 개수 No.12916 */

class Solution {
    boolean solution(String s) {
        return s.chars().filter(c->c=='P'||c=='p').count()==s.chars().filter(c->c=='Y'||c=='y').count();
    }
}
