class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length - 1};
        int min = sequence.length + 1; 
        int start = 0;
        int end = 0;
        int sum = sequence[0]; // 처음에 0번째 원소 하나만 더해둔 상태로 시작
        
        while (start < sequence.length) {
            // 합이 k와 같을 때
            if (sum == k) {
                int cur = end - start + 1; // 현재 구간의 길이
                if (cur < min) {
                    min = cur;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= sequence[start];
                start++;
            } 
            // 합이 k보다 작을 때
            else if (sum < k) {
                end++;
                // end가 범위를 벗어나면 종료
                if (end == sequence.length) break; 
                sum += sequence[end];
            } 
            // 합이 k보다 클 때
            else {
                sum -= sequence[start];
                start++;
            }
        }
        
        return answer;
    }
}
