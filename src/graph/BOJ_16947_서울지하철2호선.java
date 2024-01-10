package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 지하철 2호선과 같은 형태의 노선도가 주어졌을 때, 각 역과 순환선 사이의 거리를 구해보자
 *
 * [문제 풀이]
 * 모든 노드를 차례로 탐색하며 각 노드로부터 사이클이 있는지 탐색한다
 * 사이클이 발견되면 isCycle[] 배열에 사이클에 포함됨을 표시한다
 *
 * 입력된 각 노드로부터 BFS로 가장 가까운 (순환선에 속하는) 노드까지의 거리를 구한다
 */
public class BOJ_16947_서울지하철2호선 {

    static int N;
    static List<Integer>[] graph;
    static boolean[] isCycle;
    static int[] result;
    static class Node {
        int n, cnt;

        public Node(int n, int cnt) {
            this.n = n;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new List[N+1];  // 노드의 번호가 1-base이므로 길이는 N+1
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향 연결
            graph[a].add(b);
            graph[b].add(a);
        }

        solution();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }

    private static void solution() {
        for (int i = 1; i <= N; i++) {
            isCycle = new boolean[N+1];
            if (checkCycle(i, i, i)) break;
        }

        result = new int[N+1];
        for (int i = 1; i <= N; i++) {
            if (!isCycle[i]) result[i] = bfs(i);
        }
    }

    private static boolean checkCycle(int prev, int cur, int start) {
        isCycle[cur] = true;
        for (int next : graph[cur]) {
            if (!isCycle[next]) {  // 사이클 표시가 안된 노드인 경우
                if (checkCycle(cur, next, start)) return true;
            } else {  // 사이클 표시가 된 경우인 경우
                // 직전 노드가 아니면서 시작 노드와 같은 경우 사이클임을 알 수 있음
                if (next == start && next != prev) return true;
            }
        }
        isCycle[cur] = false;

        return false;
    }

    private static int bfs(int node) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        queue.add(new Node(node, 0));
        visited[node] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (isCycle[cur.n]) return cur.cnt;  // 사이클에 포함된 노드를 만난 경우

            for (int next : graph[cur.n]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, cur.cnt+1));
                }
            }
        }

        return 0;
    }

}