package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 도시 개수
        int M = Integer.parseInt(br.readLine());  // 간선 개수
        int[][] edges = new int[M][];
        for (int i = 0; i < M; i++) {
            edges[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int dest = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(N, edges, start, dest));
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int dijkstra(int v, int[][] data, int start, int dest) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        int[] dist = new int[v + 1];

        // 각 위치에 대한 초기값은 모두 무한대로
        for (int i = 1; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.weight));
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 이미 dist 배열에 입력해 놓은 값이 새로 넣으려는 값보다 작으면 갱신할 필요가 없으므로
            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            // 그게 아니라면 인접 노드 돌면서 업데이트
            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to] = curNode.weight + adjNode.weight;  // 더 작은 값인 우변 값으로 갱신
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        return dist[dest];
    }
}