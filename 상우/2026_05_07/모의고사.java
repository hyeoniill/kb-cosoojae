/* 수포자의 패턴을 비교하면서
- answers랑 비교
- 맞은 개수 카운트
- 최대값 찾기 */
class Solution {
    public int[] solution(int[] answers) {
        //각 수포자의 찍는 패턴
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] score = new int[3];   //맞은 문제 개수 저장(0 : 1번, 1 : 2번, 2 : 3번 )
        
        for(int i = 0; i < answers.length; i++){    //정답 배열 순회
            if(answers[i] == p1[i % p1.length]) score[0]++; //패턴 반복
            if(answers[i] == p2[i % p2.length]) score[1]++;
            if(answers[i] == p3[i % p3.length]) score[2]++;
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2])); //세 사람 중 가장 높은 점수 찾기
        int cnt = 0;    //최고 점수를 가진 사람 수를 세기 위한 변수(2명 이상이 될 수도 있기 떄문)
        for(int i = 0; i < 3; i++){ //최고 점수와 같은 사람 수 카운트
            if(score[i] == max) cnt++;  //최고 점수면 cnt 증가
        }
        
        int[] result = new int[cnt];    //결과 배열 생성(크기를 정확히 맞추기 위해 cnt 사용)
        int idx = 0;    //결과 배열에 넣을 인덱스
        for(int i = 0; i < 3; i++){ //최고 점수 받은 사람 번호를 결과 배열에 저장
            if(score[i] == max){
                result[idx++] = i + 1;  //사람 번호는 1부터 시작
            }
        }
        return result;
    }
}
