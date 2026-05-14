class Solution {
    public int solution(String s) {
        // 완전탐색
        // 문자열 길이 1, 2, 3, ..., s.length() / 2 단위까지 시도
        // 각 경우에 대해서 압축 문자열의 길이를 min값과 비교 후 업데이트
        // O(N^2) 이어도 100만 정도의 연산
        int N = s.length();
        int answer = N;
        
        for (int len = 1; len <= N / 2; len++) {
            StringBuilder sb = new StringBuilder();
            String prevS = s.substring(0, len);
            int count = 1;
            int index = len;
            
            //처음으로 len만큼 자른 이후부터, 이전 문자열과 현재 문자열 비교
            for (; index <= N - len; index += len) {
                String curS = s.substring(index, index + len);

                if (curS.equals(prevS)) {
                    count++;
                } else { //현재 문자열이 이전문자열과 다른 경우
                    updateSb(count, prevS, sb);
                    count = 1;
                    prevS = curS; //이전 문자열을 현재 문자열로 업데이트
                }
            }
            
            //반복문에서 처리되지 않은 마지막 문자열(현재 prevS)에 대한 정보를 sb에 업데이트
            updateSb(count, prevS, sb);
            
            //len으로 자른 마지막 문자열 이후에 여전히 남아 있는 문자열이 있다면 sb에 추가
            sb.append(s.substring(index, N));
            
            //현재 sb의 길이와 answer의 길이 중 더 작은 값으로 정담 업데이트
            answer = Math.min(sb.length(), answer);
        }
        
        return answer;
    }
    
    public void updateSb(int count, String prevS, StringBuilder sb) {
        if (count == 1) { //이전 문자열이 1번만 등장했다면
            sb.append(prevS);
        } else { //이전 문자열이 여러번 등장했다면
            sb.append(count).append(prevS);
        }
    }
}
