package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 각 다리마다 다리 위를 지날 수 있는 무게 제한이 존재한다
 * 자신이 머물던 집에서 혜빈이에게 갈 수 있는 최대한의 금빼빼로만을 들고 가려고 한다
 *
 * 이때, 숭이의 출발 위치에서 혜빈이의 위치까지 숭이가 들고 갈 수 있는 금빼빼로의 최대 개수를 구하라
 *
 * [문제 풀이]
 *
 */
public class BOJ_13905_세부 {

    static int V, E, s, e;
    static Edge[] edges;
    static int[] parents;
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return (weight - o.weight) * -1;  // 내림차순 정렬
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        edges = new Edge[E];
        parents = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(from, to, weight);
        }

        System.out.println(solution());
    }

    private static int solution() {
        Arrays.sort(edges);  // 가중치 기준 내림차순 정렬

        int res = 0;
        for (Edge edge : edges) {
            if (find(edge.from) != find(edge.to)) {
                union(edge.from, edge.to);
                if (find(s) == find(e)) {
                    res = edge.weight;  // 내림차순 정렬이므로 반복문이 진행될수록 값이 작아짐. 그 값이 곧 문제의 답
                    break;
                }
            }
        }

        return res;
    }

    private static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootY > rootX) {
            parents[rootY] = rootX;
        } else {
            parents[rootX] = rootY;
        }
    }

    private static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
}
