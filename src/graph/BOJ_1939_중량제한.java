package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1939_중량제한 {

    static int N, M;
    static int start, end;
    static int max, min;
    static List<List<Node>> graph;
    static int result;
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        max = Integer.MIN_VALUE;  // 가중치 최댓값
        min = Integer.MAX_VALUE;  // 가중치 최솟값
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            max = Math.max(max, weight);
            min = Math.min(min, weight);

            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());  // 출발지
        end = Integer.parseInt(st.nextToken());  // 도착지

        solution();
        System.out.println(result);
    }

    static void solution() {
        while (min <= max) {
            int mid = (max + min) / 2;

            if (bfs(mid)) {  // mid를 운반할 수 있으므로 더 높은 무게를 테스트해보자
                min = mid + 1;
                result = mid;
            } else {
                max = mid - 1;
            }
        }
    }

    /**
     * 주어진 무게를 운반할 수 있는 경로가 존재하면 true 반환
     * @param weight
     * @return
     */
    static boolean bfs(int weight) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        que.add(start);
        visited[start] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur == end) {
                return true;
            }

            for (Node adj : graph.get(cur)) {
                if (!visited[adj.to] && adj.weight >= weight) {
                    visited[adj.to] = true;
                    que.add(adj.to);
                }
            }
        }

        return false;
    }

}