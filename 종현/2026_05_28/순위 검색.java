/* 순위검색 No.72412 */

import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();
        
        String[] lang = {"java", "python", "cpp", "-"};
        String[] dev = {"frontend", "backend", "-"};
        String[] career = {"senior", "junior", "-"};
        String[] food = {"chicken", "pizza", "-"};
        
        for (String l : lang) {
            for (String d : dev) {
                for (String c : career) {
                    for (String f : food) {
                        String key = l+d+c+f;
                        map.put(key, new ArrayList<>());
                    }
                }
            }
        }
        
        for(String i : info) {
            String[] data = i.split(" ");
            String curLang = data[0];
            String curDev = data[1];
            String curCareer = data[2];
            String curFood = data[3];
            int curPoint = Integer.parseInt(data[4]);
            for (String cl : new String[]{curLang, "-"}) {
                for (String cd : new String[]{curDev, "-"}) {
                    for (String cc : new String[]{curCareer, "-"}) {
                        for (String cf : new String[]{curFood, "-"}) {
                            String key = cl+cd+cc+cf;
                            map.get(key).add(curPoint);
                        }
                    }
                }
            }
        }
        int[] answer = new int[query.length];
        
        for(int i=0; i<query.length; i++) {
            String q = query[i].replace(" and ", " ");
            String[] data = q.split(" ");
            String curLang = data[0];
            String curDev = data[1];
            String curCareer = data[2];
            String curFood = data[3];
            int qPoint = Integer.parseInt(data[4]);
            int result = 0;
            List<Integer> curList = map.get(curLang + curDev + curCareer + curFood);
            for(int p : curList) {
                if(qPoint <= p) result++;
            }
            answer[i] = result;
        }
        return answer;
    }
}
