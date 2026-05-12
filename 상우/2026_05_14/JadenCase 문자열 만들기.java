class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;   //현재 문자가 첫글자인지 확인
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){   //공백
                sb.append(c);   //공백 추가
                first = true;   //다음 문자는 단어의 첫글자
            } else if(first) {  //첫글자인 경우
                    sb.append(Character.toUpperCase(c));    //대문자로 변환해서 추가
                    first = false;  //이제 첫글자 아님
                } else{ //첫글자 아닌 경우
                    sb.append(Character.toLowerCase(c));    //소문자로 변환해서 추가
                }
            }
        return sb.toString();
    }
}
