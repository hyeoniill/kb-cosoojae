import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<Integer>();
        Map<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new ArrayList<>());
                map.get(ch).add(i);
                answer.add(-1);
            }
            else{
                map.get(ch).add(i);
                List<Integer> curr = map.get(ch);
                answer.add(curr.get(curr.size() - 1) - curr.get(curr.size() - 2));
            }
        }
        
        int[] myanswer = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            myanswer[i] = answer.get(i);
        }
        return myanswer;
    }
}