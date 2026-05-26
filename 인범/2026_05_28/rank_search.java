import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        // String을 Key로 가지는 해시맵을 사용해서 쿼리를 나눠줄 생각
        HashMap<String, ArrayList<Integer>> table = new HashMap<>();
        int[] answer = new int[query.length];

        // info에 있는 각 record를 가지고 key를 생성해줌
        for (String record : info) {
            String[] attributes = record.split(" ");
            String[] keys = Arrays.copyOfRange(attributes, 0, 4);
            int score = Integer.parseInt(attributes[4]);

            // 4개의 조건에 대해서 "-"가 들어갈 수 있는 모든 조합을 만들어줌
            // 비트 마스킹을 이용하는 방법. Combinations 구현해도 됨.
            for (int mask = 0; mask < (1 << 4); mask++) {
                String[] temp = keys.clone();

                for (int col = 0; col < 4; col++) {
                    if ((mask & (1 << col)) != 0) {
                        temp[col] = "-";
                    }
                }

                // 튜플 대신 문자열로 key를 만들어서 사용함. 튜플이 좋긴한데, 나도 처음엔 문자열로 했으니 뭐.
                String key = String.join(" ", temp);

                table.putIfAbsent(key, new ArrayList<>());
                table.get(key).add(score);
            }
        }

        // 모든 테이블의 scores 를 정렬해버림. O(N*logN)
        // 이러면 query를 처리할 때마다 O(logN) 으로 이진 탐색이 가능해짐
        for (String key : table.keySet()) {
            Collections.sort(table.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            // "and"를 제거해서 info와 같은 형태로 맞춰줌
            String q = query[i].replace(" and ", " ");
            String[] parts = q.split(" ");

            String lang = parts[0];
            String job = parts[1];
            String career = parts[2];
            String food = parts[3];
            int score = Integer.parseInt(parts[4]);
            
            // 문자열을 Key로 사용하기
            String key = String.join(" ", lang, job, career, food);
            ArrayList<Integer> scores = table.getOrDefault(key, new ArrayList<>());
            
            // 이진 탐색 인덱스 설정하기
            int start = 0;
            int end = scores.size();

            // score 이상인 첫 번째 위치를 찾는 이진 탐색
            while (start < end) {
                int mid = (start + end) / 2;

                if (score <= scores.get(mid)) {
                    end = mid; // score에 해당하더라도, 가장 먼저 score에 해당하는 인덱스를 골라야 하니까(거리계산용) 다시 순회함
                } else {
                    start = mid + 1;
                }
            }

            answer[i] = scores.size() - start; // score 이상의 값을 찾으니까, 전체에서 score가 시작하는 인덱스로 빼주면 크기가 나옴
        }

        return answer;
    }
}