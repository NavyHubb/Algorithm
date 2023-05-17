package graph.bellmanFord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1865 {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M, W;
    static List<Edge> edges;
    static int INF = 987654321;

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            // 도로 등록
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T));
            }

            // 웜홀 등록
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S, E, -1 * T));
            }

            if (bellmanFord(N, edges)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean bellmanFord(int v, List<Edge> edges) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;  // 임의의 출발점 1

        for (int i = 1; i < v; i++) {
            for (Edge edge : edges) {
                if (dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
            }
        }

        for (Edge edge : edges) {
            if (dist[edge.to] > dist[edge.from] + edge.weight) {
                return true;
            }
        }

        return false;
    }
}