package shortestPath;

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
 * 각 노드로부터 가장 가까운 면접장의 거리를 찾고
 * 그 중 면접장까지의 최단거리가 가장 큰 노드의 번호와 그 거리를 구하라
 *
 * [문제 풀이]
 * 각 면접장으로부터 가장 먼 노드를 찾는 다익스트라를 수행한다
 * 기본적인 다익스트라는 하나의 출발노드를 갖지만 이 문제의 경우 K개만큼의 출발노드를 가진다
 *
 * 각 노드로부터 면접장으로의 방향이 아닌 면접장으로부터 역방향으로의 탐색이기에
 * 입력으로 주어지는 간선의 방향을 역방향으로 저장하여 사용한다
 */
public class BOJ_17835_면접보는승범이네 {

    static final int INF = 1_000_000_000;
    static int V, E, K;
    static List<Node>[] graph;
    static int[] result;
    static int[] post;
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

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new List[V+1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        result = new int[V+1];
        Arrays.fill(result, INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 간선의 방향을 역방향으로 저장
            graph[to].add(new Node(from, weight));
        }

        post = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }

    private static void solution() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);

        for (int i : post) {
            pq.add(new Node(i, 0));
            dist[i] = 0;
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.to] < cur.weight) continue;

            for (Node adj : graph[cur.to]) {
                if (dist[adj.to] > dist[cur.to] + adj.weight) {
                    dist[adj.to] = dist[cur.to] + adj.weight;
                    pq.add(new Node(adj.to, dist[adj.to]));
                }
            }
        }

        int n = 0;
        int maxDist = 0;
        for (int i = 1; i < result.length; i++) {
            if (dist[i] > maxDist) {
                n = i;
                maxDist = dist[i];
            }
        }

        System.out.println(n);
        System.out.println(maxDist);
    }

}
