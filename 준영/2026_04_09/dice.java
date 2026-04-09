import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(a, hm.getOrDefault(a, 0) + 1);
        hm.put(b, hm.getOrDefault(b, 0) + 1);
        hm.put(c, hm.getOrDefault(c, 0) + 1);
        hm.put(d, hm.getOrDefault(d, 0) + 1);

        // 1 1 1 1 ,  1 1 2, 1 3, 2 2, 4
        if (hm.size() == 4) {
            int min_num = 7;
            for (int n : hm.keySet()) {
                if (min_num > n) {
                    min_num = n;
                }
            }
            answer = min_num;
        } else if (hm.size() == 3) {
            int[] k = new int[2];
            int i = 0;
            for (int key : hm.keySet()) {
                if (hm.get(key) == 1) {
                    k[i] = key;
                    i++;
                }
            }
            answer = k[0] * k[1];
        } else if (hm.size() == 2) {
            int[] k = new int[2];
            if (hm.containsValue(2)) {
                int i = 0;
                for (int key : hm.keySet()) {
                    k[i] = key;
                    i++;
                }
                answer = (k[0] + k[1]) * Math.abs(k[0] - k[1]);
            } else {
                for (int key : hm.keySet()) {
                    if (hm.get(key) == 3) {
                        k[0] = key;     // p
                    } else {
                        k[1] = key;     // q
                    }
                }
                answer = (10 * k[0] + k[1]) * (10 * k[0] + k[1]);
            }
        } else {
            int n = 0;
            for (int key : hm.keySet()) {
                n = key;
            }
            answer = 1111 * n;
        }

        return answer;
    }
}
