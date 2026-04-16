class Solution {
    public String solution(String number, int k) {
        String answer = "";
        // 앞에서 부터 숫자를 읽을 때 순서를 저장
        int n = 0;

        // String을 char형으로 하나씩 가져오기
        // 전체 길이 - 제거 수 = 출력할 자리 수
        for (int i = 0; i < number.length()-k; i++) {
            // 최댓값 저장
            int max = 0;
            // 첫번째 자리가 이동가능 총 거리
            // 0 ~ k + indexNum + 1 -> 뺀 숫자만큼 이동 가능하니까
            for (int j = n; j < k + i + 1; j++){
                // 큰 수 저장
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    // 큰 수의 위치 저장
                    n = j;
                }
            }
            answer += max;
            // 사용한 큰 수 다음 수부터 시작
            n += 1;
        }

        return answer;
    }
}

// 시간 초과 --------------------------------------------------

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        // 앞에서 부터 숫자를 읽을 때 순서를 저장
        int n = 0;

        // String을 char형으로 하나씩 가져오기
        // 전체 길이 - 제거 수 = 출력할 자리 수
        for (int i = 0; i < number.length()-k; i++) {
            // 최댓값 저장
            int max = 0;
            // 첫번째 자리가 이동가능 총 거리
            // 0 ~ k + indexNum + 1 -> 뺀 숫자만큼 이동 가능하니까
            for (int j = n; j < k + i + 1; j++){
                // 큰 수 저장
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    // 큰 수의 위치 저장
                    n = j;
                    // 시간 초과: 9일 때 즉시 중지
                    if (max == 9) break;
                }
            }
            answer += max;
            // 사용한 큰 수 다음 수부터 시작
            n += 1;
        }

        return answer;
    }
}

// 시간 초과 해결 --------------------------------------------------
