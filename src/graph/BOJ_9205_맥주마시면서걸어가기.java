package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기 {

    static int N;  // 편의점 갯수
    static Point[] points;
    static StringBuilder sb = new StringBuilder();
    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            points = new Point[N+2];
            for (int k = 0; k < N+2; k++) {
                st = new StringTokenizer(br.readLine());

                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());

                points[k] = new Point(i, j);
            }

            sb.append(solution() ? "happy" : "sad").append('\n');
        }
        System.out.println(sb);
    }

    static boolean solution() {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N+2];

        que.offer(0);

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (getDist(cur, N+1) <= 1000) {
                return true;
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;

                if (getDist(cur, i) <= 1000) {
                    visited[i] = true;
                    que.offer(i);
                }
            }
        }

        return false;
    }

    static int getDist(int i, int j) {
        return Math.abs(points[i].i - points[j].i) + Math.abs(points[i].j - points[j].j);
    }

}