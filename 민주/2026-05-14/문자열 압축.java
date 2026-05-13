/**
 * [핵심 아이디어]
 * - 문자열을 unit 단위로 잘라 이전 문자열과 비교
 * - 같은 문자열이 반복되면 개수를 세고, 달라지면 압축 결과에 추가
 * - 모든 unit(1 ~ 길이/2)을 시도하며 최소 길이 갱신
 *
 * [시간 복잡도]
 * - O(N^2)
 *
 * [공간 복잡도]
 * - O(N)
 */
class Solution {
    public int solution(String s) {

        StringBuilder sb = new StringBuilder();

        //단위는 1부터
        int unit = 1;
        int min = Integer.MAX_VALUE;

        //길이의 반까지만 단위로 설정
        while(unit <= s.length() / 2){

            //stringBuilder 초기화
            sb.setLength(0);

            //첫 기준 글자
            String std = s.substring(0, unit);
            int count = 1;

            int i = unit;

            //인덱스 + 단위가 길이를 넘지 않을 때까지
            while(i + unit <= s.length()){

                //비교할 다음 글자
                String comp = s.substring(i, i + unit);

                //같으면 카운트 up
                if (std.equals(comp)) {
                    count++;
                }

                //다르면 이전 기준 글자를 append 해주고 기준 글자 재설정
                else {
                    if (count > 1) sb.append(count);
                    sb.append(std);

                    std = comp;
                    count = 1;
                }

                i+= unit;
            }

            //더해지지 못한 글자 append
            if (count > 1) sb.append(count);
            sb.append(std);

            //남는 글자 append
            if (i < s.length()) {
                sb.append(s.substring(i));
            }


            min = Math.min(min, sb.length());
            unit++;
        }

        return min;
    }
}

//             for (int i = unit; i < s.length() - unit; i += unit){
//                 String comp;
//                 if (i + unit >= s.length()){
//                     comp = s.substring(i, s.length());
//                     last = true;
//                 }
//                 else{
//                     comp = s.substring(i, i + unit);
//                 }

//                 if (!std.equals(comp)){
//                     if (count != 1) sb.append(count);
//                     sb.append(std);
//                     std = comp;
//                     count = 1;
//                     if (last) {
//                         sb.append(std);
//                     }
//                 }
//                 else {
//                     count ++;
//                     if (last) {
//                         sb.append(count);
//                         sb.append(std);
//                     }
//                 }
//             }

//             String result = sb.toString();

//             if (result.length() < min) {
//                 min = result.length();
//             }
//             unit++;
