/**
 * [핵심 아이디어]
 * - 공백 이후 첫 문자는 대문자, 나머지는 소문자로 변환
 * - 공백을 만나면 다음 문자를 첫 문자로 처리
 * - 문자열을 그대로 순회하며 JadenCase 형태로 변환
 *
 * [시간 복잡도]
 * - O(N)
 *
 * [공간 복잡도]
 * - O(N)
 */

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;

        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' ') {
                sb.append(" ");
                first = true;
            }
            else {
                if (first) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                    first = false;
                }
                else {
                    sb.append(Character.toLowerCase(s.charAt(i)));
                }

            }
        }
        return sb.toString();
    }
}

/**
 * split 쓴 답
 */
// class Solution {
//     public String solution(String s) {
//         StringBuilder sb = new StringBuilder();

//         //빈 문자열 (" ")도 유지 해야함
//         //공백 기준 String 배열 만들기
//         String[] arr = s.split(" ", -1);

//         //각각의 String을 순회
//         for (int j = 0; j < arr.length; j++){
//             char[] cArr = arr[j].toCharArray();

//             //각 String 내부 char 순회
//             for (int i = 0; i < carr.length; i++){
//                 //첫문자는 무조건 대문자
//                 if (i == 0) {
//                     cArr[i] = Character.toUpperCase(cArr[i]);
//                     //나머지 소문자
//                 } else {
//                     cArr[i] = Character.toLowerCase(cArr[i]);
//                 }
//             }
//             sb.append(new String(cArr));

//             //중간에는 기존 공백 유지하기 위해 넣어주기
//             if (j != arr.length - 1){
//                 sb.append(" ");
//             }
//         }

//         return sb.toString();
//     }
// }
