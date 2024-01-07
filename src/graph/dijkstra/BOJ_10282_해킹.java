package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * a가 b에 의존할 때, a가 감염되면 s초 후 b도 감염된다
 * 총 감염되는 컴퓨터 수, 마지막 컴퓨터가 감염되기까지 걸리는 시간
 *
 * [문제 풀이]
 *
 */
public class BOJ_10282_해킹 {

    static final int INF = Integer.MAX_VALUE;
    static int V, E, start;
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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());

            graph = new List[V+1];
            for (int i = 1; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }
            dist = new int[V+1];
            Arrays.fill(dist, INF);

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                // a가 b에 의존하는 경우, 그래프에서의 방향성은 b에서 a임을 유의
                graph[to].add(new Node(from, weight));
            }

            solution();

            int cnt = 0;  // 오염된 컴퓨터 개수
            int maxTime = 0;  // 마지막 컴퓨터가 감염되는 데 걸리는 시간
            for (int i = 1; i < dist.length; i++) {
                if (dist[i] != INF) {
                    cnt++;
                    maxTime = Math.max(maxTime, dist[i]);
                }
            }

            sb.append(cnt).append(' ').append(maxTime).append('\n');
        }

        System.out.println(sb);
    }

    private static void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        dist[start] = 0;

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
