import java.util.HashSet;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int turn = 1;  // 사람 수만큼 턴이 몇번 지났는지 세기
        int p = 0;
        boolean pass = true;
        HashSet<String> hs = new HashSet<>();
        for (int i = 1; i < words.length; i++) {
            p = i % n + 1;  // 사람 번호
            if (i % n == 0) {
                turn++;        // 사이클 완료 -> 차례 + 1
            }
            char e = words[i - 1].charAt(words[i - 1].length() - 1);
            char s = words[i].charAt(0);
            if (s != e) {       // 끝말잇기 틀린 경우
                pass = false;
                answer[0] = p;
                answer[1] = turn;
                break;
            }
            hs.add(words[i - 1]);
            if (hs.contains(words[i])) {     // 이미 존재하는 단어라면
                pass = false;
                answer[0] = p;
                answer[1] = turn;
                break;
            }

        }
        if (pass == true) {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}
