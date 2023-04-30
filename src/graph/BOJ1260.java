package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {
    static StringBuilder sb = new StringBuilder();
    static boolean[] check;
    static int[][] arr;
    static int node, line, start;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());  // 노드의 개수
        line = Integer.parseInt(st.nextToken());  // 간선의 개수
        start = Integer.parseInt(st.nextToken());  // 탐색을 시작할 정점의 번호

        arr = new int[node + 1][node + 1];  // arr[i][j] = 1 이면 두 노드는 연결된 상태
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        dfs(start);
        sb.append('\n');

        check = new boolean[node + 1];  // check 배열 초기화
        bfs(start);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        check[start] = true;  // 시작 노드를 방문 처리
        sb.append(start).append(" ");

        // 시작 노드의 인접 노드 중 방문하지 않은 노드가 있으면 그 노드에 대해 재귀(해당 노드를 스택에 넣는 것과 같은 효과)
        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.add(start);  // 시작 노드를 큐에 삽입
        check[start] = true;  // 시작 노드를 방문 처리

        while (!q.isEmpty()) {
            start = q.poll();  // 큐에서 하나의 노드를 꺼낸다
            sb.append(start).append(" ");  // 큐에서 꺼낸 순서가 곧 BFS 탐색 순서

            // 꺼낸 노드의 인접 노드 중 방문하지 않은 노드를 방문하고, 차례대로 큐에 삽입한다. 이를 반복
            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}