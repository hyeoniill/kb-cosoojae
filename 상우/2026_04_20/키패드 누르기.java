class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        // 현재 위치
        int left = 10;  // *
        int right = 12; // #
        
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) { // 왼쪽 열
                answer.append("L");
                left = num; // 왼손 위치 이동
            } else if (num == 3 || num == 6 || num == 9) { // 오른쪽 열
                answer.append("R");
                right = num; // 오른손 위치 이동
            } else { // 가운데 열
                if (num == 0) num = 11; // 키패드 0을 11로 변환
                
                // 왼손, 오른속 각각 거리 계산
                int leftDist = getDistance(left, num);
                int rightDist = getDistance(right, num);
                
                if (leftDist < rightDist) { // 왼손이 더 가까운 경우
                    answer.append("L");
                    left = num;
                } else if (rightDist < leftDist) { // 오른손이 더 가까운 경우
                    answer.append("R");
                    right = num;
                } else { // 거리가 같은 경우
                    if (hand.equals("right")) {
                        answer.append("R");
                        right = num;
                    } else {
                        answer.append("L");
                        left = num;
                    }
                }
            }
        }
        
        return answer.toString();
    }
    
    // 거리 계산 함수
    private int getDistance(int from, int to) {
        // 현재 위치를 (행, 열) 좌표로 바꿈
        // 예 : 1 -> (0, 0), 5 -> (1, 1)
        int x1 = (from - 1) / 3;
        int y1 = (from - 1) % 3;
        
        //목표 위치 좌표
        int x2 = (to - 1) / 3;
        int y2 = (to - 1) % 3;
        
        // 거리 = |행 차이| + |열 차이|
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
