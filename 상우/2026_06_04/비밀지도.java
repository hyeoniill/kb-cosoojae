class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {   //각 행 처리
            int map = arr1[i] | arr2[i];    //두 지도를 OR 연산
            String binary = Integer.toBinaryString(map);    //이진수 문자열로 변환

            while (binary.length() < n) {   //길이가 n보다 작으면 앞에 0 채우기
                binary = "0" + binary;
            }

            StringBuilder sb = new StringBuilder(); //문자열 생성

            for (int j = 0; j < n; j++) {
                if (binary.charAt(j) == '1') {  //벽
                    sb.append("#");
                } else {
                    sb.append(" "); //공백
                }
            }
            answer[i] = sb.toString();  //한 줄 저장
        }
        return answer;
    }
}
