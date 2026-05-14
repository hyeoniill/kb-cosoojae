class Solution {
    public static int Cut(String s, int cut) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for (int i = start; i < s.length() - cut + 1; i += cut) {
            String sub = s.substring(i, i + cut); // 기준
            cnt = 1;
            for (int j = i + cut; j < s.length() - cut + 1; j += cut) {
                String sub2 = s.substring(j, j + cut);
                if (sub.equals(sub2)) {
                    i = j;
                    cnt++;
                } else {
                    break;
                }
            }
            if (cnt > 1) {
                sb.append(cnt).append(sub);
            } else {
                sb.append(sub);
            }
        }
        if (s.length() % cut == 0) {
            return sb.toString().length();
        } else {
            sb.append(s.substring(s.length() - s.length() % cut, s.length()));
            return sb.toString().length();
        }

    }

    public static int solution(String s) {
        int min_length = s.length();

        for (int i = 1; i <= s.length() / 2; i++) { // 1,2,...씩 자르기
            min_length = Math.min(min_length, Cut(s, i));
        }

        return min_length;

    }
}
