package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 맵에서 0은 이동할 수 있는 곳을 나타내고, 1은 이동할 수 없는 벽이 있는 곳을 나타낸다
 * 최단경로는 맵에서 가장 적은 개수의 칸을 지나는 경로를 말하는데, 이때 시작하는 칸과 끝나는 칸도 포함한다
 * 만약에 이동하는 도중에 벽을 부수고 이동하는 것이 좀 더 경로가 짧아진다면, 벽을 K개 까지 부수고 이동하여도 된다
 *
 * [문제 풀이]
 *
 */
public class BOJ_14442_벽부수고이동하기2 {
    static int N, M, K;
    static boolean[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) == '1' ? true : false;
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][K+1];

        queue.add(new int[]{0, 0, 0, 1});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1], k = cur[2], cnt = cur[3];

            if (i == N-1 && j == M-1) return cnt;

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;

                if (map[ni][nj]) {  // 벽인 경우
                    if (k < K && !visited[ni][nj][k+1]) {  // 벽을 부술 수 있는 기회가 남아있고 아직 방문하지 않은 위치인 경우
                        visited[ni][nj][k+1] = true;
                        queue.add(new int[]{ni, nj, k+1, cnt+1});
                    }
                } else {  // 이동할 수 있는 경우
                    if (!visited[ni][nj][k]) {  // 벽을 부술 수 있는 기회가 남아있고 아직 방문하지 않은 위치인 경우
                        visited[ni][nj][k] = true;
                        queue.add(new int[]{ni, nj, k, cnt+1});
                    }
                }
            }
        }

        return -1;
    }

}
