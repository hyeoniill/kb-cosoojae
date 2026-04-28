class Solution {
    public int[] solution(int n, String[] words) {
        
        // 1번째 단어부터
        for (int i = 1; i < words.length; i++) {
            String current = words[i];     // 지금 내단어
            String previous = words[i - 1]; // 방금전 사람이 말한단어
            
            // 이전 단어 마지막 글자 vs 현재 단어 첫 글자
            char lastChar = previous.charAt(previous.length() - 1);
            char firstChar = current.charAt(0);
            
            if (lastChar != firstChar) { //다르면 탈락
                return new int[] { (i % n) + 1, (i / n) + 1 };
            }
            
            // 내단어 0부터 직전가지 여부확인
            for (int j = 0; j < i; j++) {
                if (current.equals(words[j])) {
                    // 나온거 탈락
                    return new int[] { (i % n) + 1, (i / n) + 1 };
                }
            }
        }
        
        // 탈락 없으면
        return new int[] { 0, 0 };
    }
}
