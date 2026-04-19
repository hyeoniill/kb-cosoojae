class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] pad = { //좌표형태로 나열하기
            {3, 1}, // 0
            {0, 0}, // 1
            {0, 1}, // 2
            {0, 2}, // 3
            {1, 0}, // 4
            {1, 1}, // 5
            {1, 2}, // 6
            {2, 0}, // 7
            {2, 1}, // 8
            {2, 2}, // 9
            {3, 0}, // 10 -> *
            {3, 2}  // 11 -> #
        };
       //왼손 오른손
        int leftHand = 10; // *
        int rightHand = 11; // #
        
        StringBuilder sb = new StringBuilder(); //ai가 선언하래
        
        for (int num : numbers){
            //만약에
            if (num == 1 || num == 4 || num == 7) { //1 4 7일때 왼
                sb.append("L");       
                leftHand = num;
            } 
            else if (num == 3 || num == 6 || num == 9) { //3 6 9일때 오
                sb.append("R");      
                rightHand = num;
            } 
            //2, 5, 8, 0일때
            else {
                // 거리 계산
                int leftX = pad[leftHand][0]; //패드에서 가져오기
                int leftY = pad[leftHand][1]; 
                int rightX = pad[rightHand][0]; 
                int rightY = pad[rightHand][1];
                
                int targetX = pad[num][0];
                int targetY = pad[num][1];
                //맨해튼거리공식
                int distL = Math.abs(leftX - targetX) + Math.abs(leftY - targetY);
                int distR = Math.abs(rightX - targetX) + Math.abs(rightY - targetY);

                // 거리 비교 및 손 결정
                if (distL < distR) {
                    sb.append("L");
                    leftHand = num; //왼손 위치
                } else if (distR < distL) {
                    sb.append("R");
                    rightHand = num; //오른손 위치
                } else {
                    //거리가 같다면
                    if (hand.equals("left")) {
                        sb.append("L");
                        leftHand = num;
                    } else {
                        sb.append("R");
                        rightHand = num;
                    }
                }
            }
        }
        
        return sb.toString();    
    }
}
