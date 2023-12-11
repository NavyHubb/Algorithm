package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [조건]
 * 지훈이와 불은 매분 한칸씩 인접사방으로 이동한다
 * 지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다
 * 지훈이가 불에 타기전에 탈출할 수 있는지의 여부 그리고 얼마나 빨리 탈출할 수 있는지르 결정해야 한다
 *
 *
 */
public class BOJ_4179_불 {

    static int R, C;
    static char[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static Queue<int[]> que = new LinkedList<>();
    static Queue<int[]> fireQue = new LinkedList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char ch = str.charAt(j);
                if (ch == 'J') {
                    que.add(new int[]{i, j});
                    visited[i][j] = true;
                    ch = '.';
                } else if (ch == 'F') {
                    fireQue.add(new int[]{i, j});
                }

                map[i][j] = ch;
            }
        }

        int result = solution();
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    static int solution() {
        int cnt = 0;
        while (!que.isEmpty()) {
            // 불 확산
            int fireSize = fireQue.size();
            while (fireSize-- > 0) {
                int[] cur = fireQue.poll();
                int i = cur[0], j = cur[1];

                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;
                    if (map[ni][nj] == '.') {
                        map[ni][nj] = 'F';
                        fireQue.add(new int[]{ni, nj});
                    }
                }
            }

            // 지훈 이동
            int size = que.size();
            while (size-- > 0) {
                int[] cur = que.poll();
                int i = cur[0], j = cur[1];

                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    if (ni < 0 || nj < 0 || ni >= R || nj >= C) return cnt+1;

                    if (map[ni][nj] == '.' && !visited[ni][nj]) {
                        visited[ni][nj] = true;
                        que.add(new int[]{ni, nj});
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
}
