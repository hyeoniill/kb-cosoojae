import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] maps) {
        int[] dx = new int[] { -1, 1, 0, 0 }; // 움직임 조절
        int[] dy = new int[] { 0, 0, -1, 1 };
        int ex = maps.length - 1; // 도착지점
        int ey = maps[0].length - 1;
        int a = 0, b = 0; // 현재 위치
        Queue<int[]> sequence = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true; // 현재 위치 방문 (초기 위치)
        sequence.offer(new int[] { 0, 0, 1 });
        int distance = 0; // 이동한 거리
        while (!sequence.isEmpty()) {
            int[] now = sequence.poll(); // 순차적 접근
            if (now[0] == ex && now[1] == ey) {
                return now[2];
            }
            a = now[0];
            b = now[1];
            distance = now[2];
            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if ((nx >= 0 && nx <= ex) && (ny >= 0 && ny <= ey)) {
                    if (!visited[nx][ny] && maps[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        sequence.offer(new int[] { nx, ny, distance + 1 });
                    }
                }
            }
        }
        return -1;
    }
}
