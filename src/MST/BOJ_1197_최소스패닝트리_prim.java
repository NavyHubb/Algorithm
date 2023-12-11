package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Prim's Algorithm
 * 임의의 노드에서부터 시작하여 해당 노드에 연결된 간선 중 최소의 가중치를 가진 간선들을 선택
 *
 * 간선의 갯수가 많을 때 kruskal보다 유리
 */
public class BOJ_1197_최소스패닝트리_prim {

    static int V, E;
    static List<Node>[] graph;
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());  // 정점의 갯수
        E = Integer.parseInt(st.nextToken());  // 간선의 갯수

        graph = new List[E+1];
        for (int i = 1; i < E+1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        System.out.println(solution());
    }

    static int solution() {
        int weightSum = 0;

        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.weight - o2.weight));

        // 임의의 노드부터 시작
        pq.add(new Node(1, 0));

        int cnt = 0;  // 연결한 노드 수
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.to]) continue;

            cnt++;
            weightSum += cur.weight;
            visited[cur.to] = true;

            if (cnt == V) break;

            for (Node adj : graph[cur.to]) {  // 현재 노드에 연결되어 있는 간선들을 탐색
                if (visited[adj.to]) continue;

                pq.offer(adj);
            }
        }

        return weightSum;
    }

}
