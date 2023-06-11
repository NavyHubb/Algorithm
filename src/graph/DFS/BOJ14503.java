package graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int[][] map;
    static int N, M, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        cnt = 0;
        dfs(r, c, d);

        System.out.println(cnt);
    }

    static void dfs(int r, int c, int d) {
        // 현재칸이 청소할 수 있는 경우
        if (map[r][c] == 0) {
            map[r][c] = 2;
            cnt++;
        }

        // 주변에 청소되지 않은 빈칸이 있는지
        for (int i = 0; i < 4; i++) {
            d = (d+3) % 4;  // 반시계방향으로 90도 회전

            int nr = r + di[d];
            int nc = c + dj[d];

            // 청소가 안된 칸인 경우
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0) {
                    dfs(nr, nc, d);
                    return;  // 이 분기문에 들어온 이상 이하 코드로는 진행될 수 없도록(그렇지 않으면 위 dfs()를 끝내고 후진을 하는 경우가 발생할 수 있음)
            }
        }

        // 여기까지 코드가 도달하는 경우는
        // 네 방향 모두 청소가 되어 있거나 벽인 경우
        int back = (d+2) % 4;  // 후진
        int br = r + di[back];
        int bc = c + dj[back];

        // 벽이 아닌 경우(즉, 후진할 수 있는 경우)
        if (br >= 0 && br < N && bc >= 0 && bc < M && map[br][bc] != 1) {
            dfs(br, bc, d);  // 방향은 그대로 유지하므로 d를 그대로 사용
        }
    }

}