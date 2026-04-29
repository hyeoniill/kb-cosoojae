import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        //-1로 채워서 시작
        Arrays.fill(answer,-1);

        //map으로 문자별 마지막 인덱스 저장
        Map<Character,Integer> map = new HashMap<>();
        
        for(int i =0; i<s.length(); i++){
            //앞에 같은 문자가 나왔던 경우 현재문자 인덱스 - map 저장된 마지막 인덱스
            if(map.containsKey(s.charAt(i))){
                answer[i] = i-map.get(s.charAt(i));
                map.put(s.charAt(i),i); // 마지막 인덱스 갱신
            }else{ // 안 나온 경우 -1, map에 저장
                answer[i] = -1;
                map.put(s.charAt(i),i);
            }
        }
        return answer;
    }
}
