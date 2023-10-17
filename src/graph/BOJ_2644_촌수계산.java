package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {

    static int V, E;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(br.readLine());
        adjList = new List[V+1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adjList[p].add(c);
            adjList[c].add(p);
        }

        dfs(from, to, 0);
        System.out.println(result);
    }

    static void dfs(int from, int to, int depth) {
        if (from == to) {
            result = depth;
            return;
        }

        visited[from] = true;
        for (int next : adjList[from]) {
            if (visited[next]) continue;

            dfs(next, to, depth+1);
        }
    }

}
