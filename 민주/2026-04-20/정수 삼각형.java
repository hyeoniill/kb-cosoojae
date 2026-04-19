/**
 * [핵심 아이디어]
 * - bottom up
 *   삼각형의 아래쪽부터 누적합 계산
 *   따로 배열을 두지 않고 삼각형 배열 그대로 memoization
 * - 누적 합
 *   아래 양쪽 숫자 중 큰 수를 선택해서 더함
 *
 * [시간 복잡도]
 * - 1 + 2 + ... + N = O(N^2)
 *
 * [공간 복잡도]
 * - O(1)
 *
 * [정답 / 오답]
 * - 정답
 */
class Solution {

    int addTriangle (int[][] triangle){
        for (int i = triangle.length - 2; i >= 0; i--){
            for (int j = 0; j < triangle[i].length; j++){
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        return triangle[0][0];
    }

    public int solution(int[][] triangle) {
        return addTriangle(triangle);
    }
}
