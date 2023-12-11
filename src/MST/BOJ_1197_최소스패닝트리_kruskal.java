package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * kruskal's algorithm
 * 간선들 중 가중치가 가장 작은 간선부터 연결하되, 사이클이 발생은 피하며 노드를 연결
 */
public class BOJ_1197_최소스패닝트리_kruskal {

    static int V, E;
    static Edge[] edges;
    static int[] parents;
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());  // 정점의 갯수
        E = Integer.parseInt(st.nextToken());  // 간선의 갯수
        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, weight);
        }

        System.out.println(solution());
    }

    static int solution() {
        parents = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }

        Arrays.sort(edges);  // 가중치 기준 오름차순 정렬

        int weightSum = 0;
        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                weightSum += edge.weight;
            }
        }

        return weightSum;
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootY > rootX) {
            parents[rootY] = rootX;
        } else {
            parents[rootX] = rootY;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

}
