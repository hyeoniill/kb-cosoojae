class Solution {
    public String solution(int[] numbers, String hand) {
        // 1의 위치를 [0,0] 으로 생각
        // 4 = [1, 0] = [(4-1) / 3, (4-1) % 3]
        
        int[] curL = {3, 0};
        int[] curR = {3, 2};
        StringBuffer sb = new StringBuffer();
        
        for (int curNum: numbers) {
            if (curNum == 0 ) curNum = 11; // 0은 11이라고 생각하고 위치 처리
            int numX = (curNum - 1) / 3; // -1을 해주어야 원하는 대로 위치 처리 가능
            int numY = (curNum - 1) % 3;
            
            if (numY == 0) { // 무조건 왼쪽 업데이트
                curL[0] = numX;
                curL[1] = 0;
                sb.append("L");
            } else if (numY == 2) { // 무조건 오른쪽 업데이트
                curR[0] = numX;
                curR[1] = 2;
                sb.append("R");
            } else { // 거리에 따라 선택
                int dl = Math.abs(numX - curL[0]) + Math.abs(numY - curL[1]);
                int dr = Math.abs(numX - curR[0]) + Math.abs(numY - curR[1]);
                
                if (dl > dr) {
                    curR[0] = numX;
                    curR[1] = numY;
                    sb.append("R");
                } else if (dl < dr) {
                    curL[0] = numX;
                    curL[1] = numY;
                    sb.append("L");
                } else { // 왼손 오른손 거리가 같은 경우
                    if (hand.equals("left")) {
                        curL[0] = numX;
                        curL[1] = numY;
                        sb.append("L");
                    } else {
                        curR[0] = numX;
                        curR[1] = numY;
                        sb.append("R");
                    }
                }
            }
        }
        
        return sb.toString();
    }
}
