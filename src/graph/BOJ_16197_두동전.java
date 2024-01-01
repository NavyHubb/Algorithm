package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 두 동전 중 하나만 보드에서 떨어뜨리기 위해 눌러야 하는 버튼의 최소 횟수를 구하라
 * 두 동전 중 하나만 떨어뜨릴 수 없거나 버튼을 10번 이상 눌러야 한다면 -1을 출력하라
 *
 * [문제 풀이]
 *
 */
public class BOJ_16197_두동전 {

    static int N, M;
    static char[][] map;
    static Integer[][] coins;
    static boolean[][][][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        coins = new Integer[2][2];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if (ch == 'o') {
                    if (coins[0][0] == null) {
                        coins[0][0] = i;
                        coins[0][1] = j;
                    } else {
                        coins[1][0] = i;
                        coins[1][1] = j;
                    }
                } else {
                    map[i][j] = ch;
                }
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{coins[0][0], coins[0][1], coins[1][0], coins[1][1], 0});
        visited[coins[0][0]][coins[0][1]][coins[1][0]][coins[1][1]] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x1 = cur[0], y1 = cur[1], x2 = cur[2], y2 = cur[3], cnt = cur[4];

            if (cnt >= 10) continue;

            for (int d = 0; d < 4; d++) {
                int nx1 = x1 + di[d];
                int ny1 = y1 + dj[d];
                int nx2 = x2 + di[d];
                int ny2 = y2 + dj[d];

                if (!canMove(nx1, ny1)) {
                    nx1 = x1;
                    ny1 = y1;
                }
                if (!canMove(nx2, ny2)) {
                    nx2 = x2;
                    ny2 = y2;
                }

                int fallCnt = 0;
                if (isOut(nx1, ny1)) fallCnt++;
                if (isOut(nx2, ny2)) fallCnt++;
                if (fallCnt == 1) {  // 두 동전 중 하나의 동전만 떨어진 경우
                    return cnt+1;
                } else if (fallCnt == 0 && !visited[nx1][ny1][nx2][ny2]) {  // 두 동전 모두 떨어진 경우
                    visited[nx1][ny1][nx2][ny2] = true;
                    queue.add(new int[]{nx1, ny1, nx2, ny2, cnt+1});
                }
            }
        }

        return -1;
    }

    private static boolean canMove(int i, int j) {
        if (i >= 0 && j >= 0 && i < N && j < M && map[i][j] == '#') return false;
        return true;
    }

    private static boolean isOut(int i, int j) {
        return i < 0 || j < 0 || i >= N || j >= M;
    }

}
