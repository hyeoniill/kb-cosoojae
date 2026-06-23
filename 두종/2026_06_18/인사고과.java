import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        // 정렬 전 배열의 첫 번째 요소 참조를 저장
        int[] wanhoScore = scores[0];
        int wanhoSum = wanhoScore[0] + wanhoScore[1];
        
        // 근무 태도 점수(내림차순) 정렬, 같을 경우 동료 평가 점수(오름차순) 정렬
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        
        int maxS2 = -1;
        int rank = 1;
        
        // 1. 누가 인센티브를 받는지 필터링
        for (int[] score: scores) {
            
            // 근무 태도는 이미 내림차순 정렬되어 있으므로, 
            // 동료 평가 점수가 지금까지의 최댓값보다 작다면 두 점수 모두 누군가보다 낮은 것 (탈락)
            if (score[1] < maxS2) {
                
                // 탈락한 사람이 완호라면 인센티브를 받지 못하므로 -1 반환
                if (score == wanhoScore) {
                    return -1;
                }
            }
            else {
                // 동료 평가 점수 최댓값 업데이트
                maxS2 = score[1];
                
                // 2. 완호의 석차 구하기
                // 인센티브를 받는 사람 중 완호보다 두 점수의 합이 큰 사람의 수를 세기
                if (score[0] + score[1] > wanhoSum) {
                    rank++;
                }
            }
        }
        
        return rank;
    }
}
