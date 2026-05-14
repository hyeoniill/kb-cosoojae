class Solution {
    public String solution(String s) {
        // 문제의 조건대로 문자열 변환
        // 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자
        // 첫 문자가 알파벳이 아닐 때에는 이어지는 알파벳은 소문자
        StringBuilder sb = new StringBuilder();
        
        // 일단 모두 lower case로 만들고 시작
        s = s.toLowerCase();
        
        // 첫 문자는 대문자로
        sb.append(s.substring(0, 1).toUpperCase());
        
        // 현재 문자와 이전 문자만 보면 sb에 어떻게 추가할지 결정할 수 있다
        for (int i = 1; i < s.length(); i++) {
            char prevC = s.charAt(i - 1);
            char curC = s.charAt(i);
            
            if (curC >= '0' && curC <= '9') {
                sb.append(curC);
                continue;
            }
            
            if (prevC == ' ') {
                sb.append(Character.toUpperCase(curC));
            } else {
                sb.append(curC);
            }
        }

        return sb.toString();
    }
}
