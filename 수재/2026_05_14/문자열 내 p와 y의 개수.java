시간복잡도: O(N)
공간복잡도: O(N)

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int pCnt = 0, yCnt = 0;

        for (char c: s.toCharArray()) {
            switch (c) {
                case 'p', 'P':
                    pCnt++;
                    continue;
                case 'y', 'Y':
                    yCnt++;
                    continue;
            }
        }

        if (pCnt != yCnt) answer = false; 

        return answer;
    }
}

---------------------------------------------------
최적화

class Solution {
    boolean solution(String s) {
        int pyNum = 0;

        for (char c: s.toCharArray()) {
            switch (c) {
                case 'p', 'P':
                    pyNum++;
                    continue;
                case 'y', 'Y':
                    pyNum--;
                    continue;
            }
        }

				// p, y의 수가 같으면 true
        return pyNum == 0;
    }
}
