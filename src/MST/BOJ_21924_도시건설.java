package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제 풀이]
 * 전형적인 MST 문제이므로 kruskal로 풀이
 *
 * 건물의 개수 N은 0 < N <= 10^5
 * 도로의 비용 c는 0 < N <= 10^6 이므로
 * 최댓값을 고려하였을 때 10^11이다.
 * 이는 int 형의 범위를 벗어남을 유의
 */
public class BOJ_21924_도시건설 {

    static int V, E;
    static long total = 0;
    static Edge[] edges;
    static int[] parent;
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());  // 정점의 갯수
        E = Integer.parseInt(st.nextToken());  // 간선의 갯수
        edges = new Edge[E];
        parent = new int[V+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, weight);
            total += weight;
        }

        System.out.println(solution());
    }

    private static long solution() {
        Arrays.sort(edges);  // 가중치 기준 오름차순 정렬

        long weightSum = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                weightSum += edge.weight;
                cnt++;
            }
        }

        return cnt == V-1 ? total - weightSum : -1;
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootY > rootX) {
            parent[rootY] = rootX;
        } else {
            parent[rootX] = rootY;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

}