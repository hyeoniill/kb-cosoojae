/**
 * [핵심 아이디어]
 * - p와 y의 개수를 각각 세지 않고 하나의 count로 관리
 * - p면 +1, y면 -1 해서 최종 count가 0인지 확인
 *
 * [시간 복잡도]
 * - O(N)
 *
 * [공간 복잡도]
 * - O(N) (toCharArray 사용)
 */

class Solution {
    boolean solution(String s) {
        char[] arr = s.toCharArray();

        int count = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 'p' || arr[i] == 'P') count++;
            else if (arr[i] == 'y' || arr[i] == 'Y') count--;
        }

        if (count == 0) return true;
        return false;
    }
}
