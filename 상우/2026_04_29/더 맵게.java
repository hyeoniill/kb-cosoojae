import java.util.*;

//가장 작은 값 2개를 계속 꺼내서 섞기
class Solution {
    public int solution(int[] scoville, int K) {

        //우선순위 큐 (작은 값이 먼저 나옴)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //모든 값을 큐에 넣기
        for (int s : scoville) {
            pq.add(s);
        }

        int count = 0; //섞은 횟수

        //스코빌지수가 하나만 남으면 못섞음
        //가장 작은 스코빌지수가 K 이상이 될 때까지 계속 섞어야함
        while (pq.size() > 1 && pq.peek() < K) { //peek() : 큐에서 가장 앞에 있는 데이터(가장 오래전에 삽입 된 데이터)를 확인하는 연산

            //가장 작은 값 꺼냄
            int first = pq.poll();  //poll() : 큐의 첫번째 요소를 삭제 및 반환, 만약 큐가 비어있으면 null을 반환.
                                    //remove() : 큐의 첫번째 요소를 삭제 및 반환, 만약 큐가 비어있으면 예외 발생.
            
            //두 번째로 작은 값 꺼냄
            int second = pq.poll();

            int newFood = first + (second * 2); //새로운 음식 만들기
            pq.add(newFood);    //새 음식 다시 큐에 넣기
            count++;    //횟수 증가
        }
        
        if (pq.peek() >= K) {   //모든 음식이 K 이상인지 확인
            return count;
        }
        return -1;  //불가능한 경우
    }
}
