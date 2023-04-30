package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11724 {
    static StringBuilder sb = new StringBuilder();
    static int node, line, start;
    static int[][] arr;
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        check = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;
        }

        int count = 0;

        for (int i = 1; i <= node; i++) {
            if (!check[i]) {
                dfs(i);
//                bfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int start) {
        // 이미 방문했던 노드라면 패스
        if (check[start]) {
            return;
        }

        check[start] = true;
        for (int i = 1; i <= node; i++) {
            if (arr[start][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.add(start);
        check[start] = true;

        while (!q.isEmpty()) {
            start = q.poll();

            for (int i = 1; i <= node; i++) {
                if (arr[start][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] = true;
                }
            }
        }
    }
}