package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * (1, 1)에서 (N, M)까지 최단경로로 이동하려 한다
 * 시작하는 칸과 끝나느 칸도 포함해서 카운트한다
 * 이동하지 않고 같은 칸에 머무를 수도 있다(이동거리는 카운트한다)
 * 벽을 부수는 것은 낮에만 가능하며 낮과 밤이 하루씩 번갈아가면서 등장한다
 * 벽은 K개까지만 부술 수 있다
 *
 * [문제 풀이]
 *
 */
public class BOJ_16933_벽부수고이동하기3 {

    static int N, M, K;
    static int[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static class Node {
        int i, j, k, cnt;  // 행, 열, 벽 부순 갯수, 지나온 칸 수
        boolean isDay;

        public Node(int i, int j, int k, int cnt, boolean isDay) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.cnt = cnt;
            this.isDay = isDay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        boolean[][][] visited = new boolean[N][M][K+1];

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 0, 1, true));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.i == N-1 && cur.j == M-1) return cur.cnt;  // 목적지에 도달

            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;

                if (map[ni][nj] == 0) {  // 빈칸인 경우
                    if (visited[ni][nj][cur.k]) continue;  // 이미 방문한 곳인 경우 건너뛴다

                    visited[ni][nj][cur.k] = true;
                    queue.add(new Node(ni, nj, cur.k, cur.cnt+1, !cur.isDay));
                } else {  // 벽인 경우
                    if (cur.k < K) {  // 일단 벽을 부술 수 있는 횟수가 남아 있어야겠지
                        if (cur.isDay) {  // 낮이라면
                            if (visited[ni][nj][cur.k+1]) continue;

                            visited[ni][nj][cur.k+1] = true;
                            queue.add(new Node(ni, nj, cur.k+1, cur.cnt+1, !cur.isDay));
                        } else {  // 밤이라면
                            // 현위치 대기
                            queue.add(new Node(cur.i, cur.j, cur.k, cur.cnt+1, !cur.isDay));  // 이동거리는 카운트하므로 +1 처리
                        }
                    }
                }
            }
        }

        return -1;
    }

}