import java.util.*;
class Solution {
    List<Node> p = new ArrayList<>();
    List<Node> p2 = new ArrayList<>();
    public class Node{
        String lang;
        String major;
        String year;
        String food;
        int score;
        public Node(String lang, String major, String year, String food, int score){
            this.lang = lang;
            this.major = major;
            this.year = year;
            this.food = food;
            this.score = score;
        }
    }

    public int[] solution(String[] info, String[] query) {

        for (int i = 0; i < info.length; i++){
            String[] new_info = info[i].split(" ");
            p.add(new Node(new_info[0], new_info[1], new_info[2], new_info[3], Integer.parseInt(new_info[4])));   // 노드에 값을 저장
        }
        for (int i = 0; i < query.length; i++){
            String[] new_query = query[i].split(" and ");
            String[] s = new_query[3].split(" ");
            p2.add(new Node(new_query[0], new_query[1], new_query[2], s[0], Integer.parseInt(s[1])));
        }
        int[] answer = new int[query.length];  // 회사의 길이만큼
        for (int i = 0; i < p2.size(); i++){
            for (int j = 0; j < p.size(); j++){
                if (!(p2.get(i).lang.equals(p.get(j).lang)) && !(p2.get(i).lang.equals("-"))){
                    // 언어가 동일하지 않으면 패스
                    continue;
                }
                else if (!(p2.get(i).major.equals(p.get(j).major)) && !(p2.get(i).major.equals("-"))){
                        continue;
                }
                else if (!(p2.get(i).year.equals(p.get(j).year)) && !(p2.get(i).year.equals("-"))){
                   continue;
                }
                else if (!(p2.get(i).food.equals(p.get(j).food)) && !(p2.get(i).food.equals("-"))){
                    continue;
                }
                else if (p2.get(i).score > p.get(j).score){
                    continue;
                }
                answer[i]++;
            }
        }
        return answer;
    }
}
