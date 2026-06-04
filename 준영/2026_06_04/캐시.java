import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Map<String, Integer> city = new HashMap<>();    // 도시 이름과 시간 저장
        
        // 1. 맵의 크기가 cachSize 보다 작을 시 그냥 넣기
        // 반복문을 사용하면서 1 2 3 4 5 처럼 넣고 숫자 차이가가장 많이 나는 것이 오래된 것으로 간주
        // 2. 맵이 다 찼을 경우 : 만약 삽입되는 도시 이름이 존재할 경우 -> 우선순위 초기화
        // 2.2 : 삽입되는 도시 이름이 존재하지 않다면 우선순위가 높은 도시를 제거하고 삽입
        // 3. 해당 과정을 거치면서 시간을 계산
        if (cacheSize == 0){
            answer = 5 * cities.length;
            return answer;
        }
        for (int i = 0; i < cities.length; i++){
            // i는 시간
            String cName = cities[i].toLowerCase();
            if (city.size() < cacheSize){
                 // 캐시에 공간이 남아있다면
                if (city.keySet().contains(cName)){
                    // cache hit
                    city.replace(cName, i);
                    answer += 1;
                }
                else{
                    city.put(cName, i);
                    answer += 5;
                }
            }
            else{
                // 캐시가 가득 찼다면
                if (city.keySet().contains(cName)){
                    // cache hit
                    city.replace(cName, i);
                    answer += 1;
                }
                else{
                    // cache miss
                    // 크기 차이가 많이 나는 것을 교체
                    int minNum = i;
                    String key = "";
                    for (String k : city.keySet()){
                        if (city.get(k) <= minNum){
                            minNum = city.get(k);
                            key = k;
                        }
                    }
                    city.remove(key);
                    city.put(cName, i);
                    answer += 5;
                }
            }
        }
    
        return answer;
    }
}
