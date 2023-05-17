package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1504 {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int E;
    static int[][] edges;
    static int[] dist;
    static boolean[] visited;
    static List<List<Node>> graph;
    static int INF = 200000000;

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        edges = new int[E][];

        for (int i = 0; i < E; i++) {
            edges[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        visited = new boolean[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 인접리스트 구축
        for (int i = 0; i < E; i++) {
            graph.get(edges[i][0]).add(new Node(edges[i][1], edges[i][2]));
            graph.get(edges[i][1]).add(new Node(edges[i][0], edges[i][2]));
        }

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int res = (res1 == INF && res2 == INF) ? -1 : Math.min(res1, res2);

        System.out.println(res);
    }

    static int dijkstra(int from, int to) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        dist[from] = 0;
        pq.offer(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to]) {
                continue;
            }
            visited[cur.to] = true;

            for (Node adj : graph.get(cur.to)) {
                if (dist[adj.to] > adj.weight + cur.weight) {
                    dist[adj.to] = adj.weight + cur.weight;
                    pq.offer(new Node(adj.to, dist[adj.to]));
                }
            }
        }

        return dist[to];
    }

}