import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0; //총 실행 시간
        LinkedList<String> cache = new LinkedList<>();  //캐시 저장

        for (String city : cities) {    //도시 순회
            city = city.toLowerCase();  //대소문자 구분 안 함
            
            if (cache.contains(city)) { //캐시 히트
                answer += 1;
                cache.remove(city); //기존 위치 제거
                cache.add(city);    //가장 최근 사용으로 이동
            } else {    //캐시 미스
                answer += 5;
                if (cacheSize == 0) {   //캐시 크기가 0이면 저장 불가
                    continue;
                }
                if (cache.size() == cacheSize) {    //캐시 꽉 찼으면
                    cache.removeFirst();    //가장 오래된 데이터 제거
                }
                cache.add(city);    //새 데이터 추가
            }
        }
        return answer;
    }
}
