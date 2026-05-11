class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        s = s.toLowerCase();  //문자열을 소문자로 변환

        //한 글자씩 확인
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'p') { //현재 문자가 p
                pCount++;
            } else if (c == 'y') {  //현재 문자가 y
                yCount++;
            }
        }
        // p y 개수 같으면 true 다르면 false
        return pCount == yCount ? true : false;
    }
}
