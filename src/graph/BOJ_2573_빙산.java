package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [조건]
 * 빙산의 높이는 단위시간 당 인접한 빈칸의 갯수만큼 줄어든다
 * 한 덩어리로 주어진 빙산이 분리되는 최초 시간을 구하라
 *
 * [풀이]
 * 모든 칸에 대해 탐색하며 각 칸에 인접한 빈칸의 갯수에 따라 높이를 감소시킨다
 * 동시에 높이가 1 이상인 빙산의 갯수를 센다
 * 이때 감소 전의 높이가 5 이상인 임의의 칸의 위치를 저장하여
 * 이 위치를 시작으로 BFS 탐색하여 인접한 칸의 갯수를 센다
 * BFS로 센 갯수가 빙산 전체의 갯수에 미치지 못하면 두 덩어리 이상으로 나누어진 것이므로 이때의 시간을 반환한다
 */
public class BOJ_2573_빙산 {

    static int N, M;
    static int[][] map;
    static Queue<int[]> que;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution());
    }

    static int solution() {
        int time = 1;

        while (true) {
            int[] loc = null;

            int iceCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0) {  // 빙산이 존재하는 경우
                        int vacancyCnt = 0;  // 인접 빈공간의 갯수
                        for (int d = 0; d < 4; d++) {
                            int ni = i + di[d];
                            int nj = j + dj[d];

                            if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                            if (map[ni][nj] != 0) continue;

                            vacancyCnt++;
                        }

                        map[i][j] = (map[i][j] <= vacancyCnt) ? -1 : map[i][j] - vacancyCnt;

                        if (map[i][j] > 0) {
                            iceCnt++;
                            if (loc == null) {
                                loc = new int[]{i, j};
                            }
                        }

                    }
                }
            }

            // 삭제 대상이었던 빙하를 map에 반영
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == -1) {
                        map[i][j] = 0;
                    }
                }
            }

            if (loc != null) {  // 남은 빙산이 존재하는 경우
                if (BFS(loc[0], loc[1]) < iceCnt) {
                    return time;
                }
            } else {
                return 0;
            }

            time++;
        }
    }

    /**
     * 주어진 위치와 같은 덩어리에 포함된 칸의 갯수 탐색
     */
    static int BFS(int startI, int startJ) {
        que = new LinkedList<>();
        visited = new boolean[N][M];

        que.add(new int[]{startI, startJ});
        visited[startI][startJ] = true;
        int cnt = 1;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int i = cur[0], j = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
                if (map[ni][nj] == 0) continue;
                if (visited[ni][nj]) continue;

                visited[ni][nj] = true;
                que.add(new int[]{ni, nj});
                cnt++;
            }
        }

        return cnt;
    }

}
