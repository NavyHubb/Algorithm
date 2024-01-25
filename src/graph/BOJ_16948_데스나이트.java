package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16948_데스나이트 {

    static int N, r1, c1, r2, c2;
    static int[] di = {-2, -2, 0, 0, 2, 2};
    static int[] dj = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        r1 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());

        System.out.println(solution());
    }

    private static int solution() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new int[]{r1, c1});
        visited[r1][c1] = true;

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cur = queue.poll();
                int i = cur[0], j = cur[1];

                if (i == r2 && j == c2) return depth;

                for (int d = 0; d < di.length; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                    if (visited[ni][nj]) continue;

                    queue.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }

            depth++;
        }

        return -1;
    }

}
