package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * [조건]
 * 여러 섬들 중 아무 두 섬이나 연결하는 가장 짧은 다리의 길이를 구하라
 */
public class BOJ_2146_다리만들기 {

    static final int INF = 1_000_000;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution());
    }

    static int solution() {
        searchIsland();

        int minLen = INF;
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    result = bfs(i, j);
                    if (result != INF) {
                        minLen = Math.min(minLen, result);
                    }
                }
            }
        }

        return minLen;
    }

    static void searchIsland() {
        visited = new boolean[N][N];

        int id = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    mark(i, j, id++);
                }
            }
        }
    }

    static void mark(int startI, int startJ, int id) {
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{startI, startJ});
        visited[startI][startJ] = true;
        map[startI][startJ] = id;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int i = cur[0], j = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                if (visited[ni][nj]) continue;
                if (map[ni][nj] != 1) continue;

                visited[ni][nj] = true;
                map[ni][nj] = id;
                que.add(new int[]{ni, nj});
            }
        }
    }

    static int bfs(int startI, int startJ) {
        Queue<int[]> que = new LinkedList<>();
        visited = new boolean[N][N];

        int curId = map[startI][startJ];
        que.add(new int[]{startI, startJ});
        visited[startI][startJ] = true;

        int depth = 0;
        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                int[] cur = que.poll();
                int i = cur[0], j = cur[1];

                if (map[i][j] != 0 && map[i][j] != curId) return depth-1;  // 다른 섬을 만난 경우, 그때의 depth가 곧 최소길이이므로 그 값을 반환

                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                    if (visited[ni][nj]) continue;
                    if (map[ni][nj] == curId) continue;  // 같은 섬인 경우

                    visited[ni][nj] = true;
                    que.add(new int[]{ni, nj});
                }
            }

            if (depth == 0 && que.size() == 0) {
                return INF;
            }
            depth++;
        }

        return INF;
    }

}