import java.util.*;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> colatz = new ArrayList<>();
        colatz.add(n);

        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                colatz.add(n);
            } else {
                n = 3 * n + 1;
                colatz.add(n);
            }
        }
        
        int[] answer = colatz.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
