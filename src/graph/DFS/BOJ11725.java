package graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725 {
    static int N;  // 노드 개수
    static int[] parent;  // 각 노드의 부모 노드
    static List<Integer>[] graph;  // 트리 정보를 담은 리스트 배열
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        graph = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

//        dfs(1);
        bfs();

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parent[1] = -1;  // 방문처리

        while (!q.isEmpty()) {
            int v = q.poll();
            for (int i : graph[v]) {
                if (parent[i] == 0) {
                    q.add(i);
                    parent[i] = v;
                }
            }
        }
    }

    static void dfs(int index) {
        for (int i : graph[index]) {
            if (parent[i] == 0) {  // 저장된 값이 없다는 것은 아직 탐색되지 않은 노드라는 것
                parent[i] = index;  // index 노드에 연결된 노드 중 아직 탐색되지 않은 노드 i는 index 노드를 부모로 갖는다
                dfs(i);
            }
        }
    }

}