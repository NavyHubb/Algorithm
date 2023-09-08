package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 최소스패닝트리는 모든 정점을 연결하는 부분 그래프 중에서 그 가중치의 합이 최소인 트리
 *
 * 크루스칼로 가중치가 작은 간선부터 선택하되 from과 to가 서로 다른 간선만 선택한다
 */
public class BOJ_14621_나만안되는연애 {

    static int V, E;
    static int[] parent;
    static Edge[] edges;
    static boolean[] isMale;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        isMale = new boolean[V+1];
        for (int i = 1; i <= V; i++) {
            String sex = st.nextToken();
            if (sex.equals("M")) isMale[i] = true;
        }

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
        int weightSum = 0;

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        Arrays.sort(edges, (o1, o2) -> o1.weight - o2.weight);  // 가중치 기준 오름차순 정렬

        int cnt = 0;
        for (Edge edge : edges) {
            if (find(edge.from) == find(edge.to)) continue;  // 사이클 발생 시 해당 간선 미선택
            if (isMale[edge.from] == isMale[edge.to]) continue;

            union(edge.from, edge.to);
            weightSum += edge.weight;
            cnt++;

            if (cnt == V-1) {
                return weightSum;
            }
        }

        return -1;
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rootY > rootX) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

}