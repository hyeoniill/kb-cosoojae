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
