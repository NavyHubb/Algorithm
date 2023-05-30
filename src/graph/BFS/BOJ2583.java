package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2583 {
    static boolean[][] map;
    static int N;
    static int M;
    static List<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());  // 세로(y)
        N = Integer.parseInt(st.nextToken());  // 가로(x)
        int K = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 주어진 정보에 따라 직사각형 영역 표시하기
            for (int i = y1; i < y2; i++) {
                for (int j = x1; j < x2; j++) {
                    map[i][j] = true;
                }
            }
        }

        //BFS
        result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!map[i][j]) {
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append('\n');

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(' ');
        }

        System.out.println(sb);
    }

    static void bfs(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        map[y][x] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int blocks = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];
            blocks++;

            for (int k = 0; k < dx.length; k++) {
                int newI = i + dy[k];
                int newJ = j + dx[k];

                if (newI < 0 || newJ < 0 || newI > M-1 || newJ > N-1 || map[newI][newJ]) {
                    continue;
                }

                map[newI][newJ] = true;
                q.add(new int[]{newI, newJ});
            }
        }

        result.add(blocks);
    }
}