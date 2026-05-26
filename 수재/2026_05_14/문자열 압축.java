시간복잡도: O(N^2)
공간복잡도: O(N)

class Solution {
    public int solution(String s) {
        // 문자열 길이가 1이면 압축할 수 없으므로 1 리턴
        if (s.length() == 1) return 1;
        
        int answer = s.length();
        
        for (int i = 1; i <= s.length()/2; i++) {
            StringBuilder compressed = new StringBuilder();
            String target = s.substring(0, i); // 첫 번째 비교 대상 문자열
            int count = 1; // 중복 횟수
            
            // i만큼 건너뛰면서 문자열 비교 진행
            for (int j = i; j <= s.length(); j += i) {
                // 남은 문자열이 자르려는 단위(i)보다 작으면 남은 만큼만 자르기
                int endIdx = Math.min(j + i, s.length());
                String next = s.substring(j, endIdx);
                
                if (target.equals(next)) {
                    count++; // 문자열이 같으면 카운트 증가
                } else {
                    // 문자열이 다르면 그동안 쌓인 압축 결과 반영
                    if (count > 1) {
                        compressed.append(count);
                    }
                    compressed.append(target);
                    
                    // 기준점을 다음 문자열로 변경하고 카운트 초기화
                    target = next;
                    count = 1;
                }
            }
            
            // 루프가 끝난 후 남아있는 target 문자열 처리
            if (count > 1) {
                compressed.append(count);
            }
            compressed.append(target);
            
            // 가장 짧은 압축 문자열 길이 갱신
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}
