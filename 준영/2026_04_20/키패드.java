import java.util.*;

class Locate { // 위치 객체
    int r;
    int c;

    Locate(int r, int c) { // 위치 생성자
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // 숫자 키패드 누르는 순서 -> numbers
        // 주손잡이 -> hand
        String default_hand = ""; // 주 손잡이 저장
        if (hand.equals("right")) {
            default_hand = "R";
        } else {
            default_hand = "L";
        }

        // 왼손의 현재 위치 변수
        Locate left = new Locate(3, 0); // * 위치
        // 오른손의 현재 위치 변수
        Locate right = new Locate(3, 2); // # 위치

        // 비교할 2,4,6,8 의 좌표를 HashMap으로 저장
        HashMap<Integer, int[]> num_map = new HashMap<>();
        num_map.put(2, new int[] { 0, 1 });
        num_map.put(5, new int[] { 1, 1 });
        num_map.put(8, new int[] { 2, 1 });
        num_map.put(0, new int[] { 3, 1 });
        num_map.put(1, new int[] { 0, 0 });
        num_map.put(4, new int[] { 1, 0 });
        num_map.put(7, new int[] { 2, 0 });
        num_map.put(3, new int[] { 0, 2 });
        num_map.put(6, new int[] { 1, 2 });
        num_map.put(9, new int[] { 2, 2 });
        // 2, 5, 8, 0 을 제외하고는 움직여야 할 엄지손가락이 정해져있다.
        for (int num : numbers) {
            int[] Lo = num_map.get(num); // 해쉬맵에서 좌표 가져오기
            if (num == 2 || num == 5 || num == 8 || num == 0) {
                // 나머지 숫자에서는 왼손과 오른손을 비교해야 한다.
                int left_size = Math.abs(left.r - Lo[0])
                        + Math.abs(left.c - Lo[1]);
                int right_size = Math.abs(right.r - Lo[0])
                        + Math.abs(right.c - Lo[1]);
                if (left_size > right_size) {
                    // 왼손의 거리가 더 길 때
                    right.r = Lo[0];
                    right.c = Lo[1];
                    sb.append("R");
                } else if (right_size > left_size) {
                    // 오른손 거리가 더 길 때
                    left.r = Lo[0];
                    left.c = Lo[1];
                    sb.append("L");
                } else { // 두 손의 거리가 같을 때
                    if (default_hand.equals("R")) {
                        right.r = Lo[0];
                        right.c = Lo[1];
                        sb.append("R");
                    } else {
                        left.r = Lo[0];
                        left.c = Lo[1];
                        sb.append("L");
                    }
                }
            } else if (num == 1 || num == 4 || num == 7) {
                left.r = Lo[0];
                left.c = Lo[1];
                sb.append("L");
            } else {
                right.r = Lo[0];
                right.c = Lo[1];
                sb.append("R");
            }

        }
        answer = sb.toString();
        return answer;
    }

}
