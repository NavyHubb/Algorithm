package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1753_최단경로 {

    static final int INF = 1_000_000_000;
    static int V, E;
    static List<Node>[] graph;
    static int[] dist;
    static class Node implements Comparable<Node> {
        int to, weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[V+1];
        Arrays.fill(dist, INF);
        graph = new List[V+1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph[from].add(new Node(to, weight));
        }

        solution(start);
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == INF ? "INF" : dist[i]).append('\n');
        }
        System.out.println(sb);
    }

    private static void solution(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            for (Node adj : graph[cur.to]) {
                if (dist[adj.to] > dist[cur.to] + adj.weight) {
                    dist[adj.to] = dist[cur.to] + adj.weight;
                    pq.add(new Node(adj.to, dist[adj.to]));
                }
            }
        }
    }

}