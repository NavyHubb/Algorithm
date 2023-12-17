package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 주어진 격자판에서 칸 K개를 선택할 것이고, 선택한 칸에 들어있는 수를 모두 더한 값의 최댓값을 구하라
 * 단, 사방으로 인접하는 격자는 동시에 선택할 수 없다
 */
public class BOJ_18290_NM과K1 {

    static int N, M, K, answer = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, 0, 0);
        System.out.println(answer);
    }

    private static void solution(int x, int y, int depth, int sum) {
        if (depth == K) {  // 선택해야 하는 개수 K개만큼 선택을 마친 경우
            answer = Math.max(answer, sum);  // 선택한 칸들의 합의 최댓값 갱신
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) continue;  // 이미 선택된 위치인 경우

                if (check(i, j)) {  // 선택할 수 있는 위치인 경우
                    visited[i][j] = true;
                    solution(i, j, depth+1, sum+map[i][j]);

                    visited[i][j] = false;
                }
            }
        }
    }

    // 주어진 위치를 선택할 수 있는지 확인
    // 즉, 주어진 위치의 인접 사방에 이미 방문된 곳이 있는지 확인
    private static boolean check(int i, int j) {
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;

            if (visited[ni][nj]) {
                return false;
            }
        }

        return true;
    }

}