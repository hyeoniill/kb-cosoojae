import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        // info * query 를 하면 5000만번의 연산 -> 이 이상은 불가능
        // 조건 5개를 매번 비교하면 시간초과가 발생 (* 5 를 해야해서)
        // 언어 직군 경력 소울푸드 를 모두 표현할 수 있는 식별자 생성
        // 1. 식별자 비교, 2. 점수 비교 -> 2번의 비교 연산으로 줄이기
        // 식별자를 어떻게 만들지...? 모르겠다
        // 연산 횟수를 줄일 수 있는 다른 방법 찾기
        // info에서 나올 수 있는 모든 경우들에 대한 key들에 대해서 value로 점수를 List에 add
        // 각 info 하나당 나올 수 있는 경우는 2^4 = 16가지다 ('-' 인지 또는 현재값인지)
        // 이후 query에서 key값으로 일치하는 요소들을 찾아서 search 및 계산
        
        Map<String, List<Integer>> parsedInfo = new HashMap<>();
        
        for (int i = 0; i < info.length; i++) {
            String[] temp = info[i].split(" ");
            Integer curScore = Integer.valueOf(temp[4]);
            StringBuilder sb = new StringBuilder();
            createKey(0, sb, curScore, temp, parsedInfo);
        }
        
        for (String key: parsedInfo.keySet()) {
            Collections.sort(parsedInfo.get(key));
        }
        
        String[] parsedQuery = new String[query.length];
        
        for (int i = 0; i < query.length; i++) {
            StringBuilder sb = new StringBuilder();
            String[] temp = query[i].split("and");
            for (int j = 0; j < 4; j++) {
                if (j == 3) {
                    String foodAndScore = temp[j].strip();
                    sb.append(foodAndScore);
                    parsedQuery[i] = sb.toString();
                }
                else {
                    sb.append(temp[j].strip());
                }
            }
        }
        
        int[] answer = new int[query.length];
        
        for (int i = 0; i < parsedQuery.length; i++) {
            String key = parsedQuery[i].split(" ")[0];
            int targetScore = Integer.parseInt(parsedQuery[i].split(" ")[1]);
            
            List<Integer> list = parsedInfo.get(key);
            if (list == null) {
                answer[i] = 0;
                continue;
            }
            int count = binarySearch(list, targetScore);
            answer[i] = count;
        }
        
        return answer;
    }
    
    private void createKey(int depth, StringBuilder sb, Integer curScore, String[] temp, Map<String, List<Integer>> parsedInfo) {
        if (depth == 4) {
            if (!parsedInfo.containsKey(sb.toString())) {
                parsedInfo.put(sb.toString(), new ArrayList<Integer>());
                parsedInfo.get(sb.toString()).add(curScore);
            }
            else {
                parsedInfo.get(sb.toString()).add(curScore);
            }
            return;
        }
        
        int lenBefore = sb.length();
        sb.append(temp[depth]);
        createKey(depth + 1, sb, curScore, temp, parsedInfo);
        sb.setLength(lenBefore);

        sb.append("-");
        createKey(depth + 1, sb, curScore, temp, parsedInfo);
        sb.setLength(lenBefore);   
    }
    
    private int binarySearch(List<Integer> list, int targetScore) {
        int l = 0;
        int r = list.size();
        
        while (l < r) {
            int mid = (l + r) / 2;
            int curScore = list.get(mid);
            
            if (curScore < targetScore) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        
        return list.size() - l;
    }
}
