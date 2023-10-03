package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [조건]
 * 육지(L), 바다(W)
 * 인접 상하좌우의 육지로만 이동 가능
 * 보물은 서로 간에 최단 거리로 이동하는 데 있어 가장 긴 시간이 걸리는 육지 두 곳에 나뉘어 묻혀있다
 *
 * 지도가 주어질 때, 보물이 묻혀 있는 두 곳간의최단 거리로 이동하는 시간을 구하라
 *
 * [풀이]
 * 모든 육지인 칸에 대해서 탐색하며
 */
public class BOJ_2589_보물섬 {

    static int N, M;
    static char[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        solution();
        System.out.println(result);
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {  // 육지
                    bfs(i, j);
                }
            }
        }
    }

    static void bfs(int startI, int startJ) {
        int max = 0;

        Queue<int[]> que = new LinkedList<>();
        int[][] visited = new int[N][M];

        que.add(new int[]{startI, startJ});
        visited[startI][startJ] = 1;  // 방문하지 않은 곳과의 구분을 위해 0이 아닌 1로 초기화

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int i = cur[0], j = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextI = i + di[d];
                int nextJ = j + dj[d];

                if (nextI < 0 || nextJ < 0 || nextI > N-1 || nextJ > M-1) continue;
                if (map[nextI][nextJ] != 'L') continue;
                if (visited[nextI][nextJ] != 0) continue;

                visited[nextI][nextJ] = visited[i][j] + 1;
                que.add(new int[]{nextI, nextJ});

                max = Math.max(max, visited[nextI][nextJ]);
            }
        }

        // 최댓값 갱신
        result = Math.max(result, max-1);
    }

}
