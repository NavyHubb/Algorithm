package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.w3c.dom.Node;

public class BOJ1167 {
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;
    static int node;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        list = new ArrayList[v + 1];
        for (int i = 1; i < v + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            int from = sc.nextInt();
            while (true) {
                int to = sc.nextInt();
                if (to == -1) break;

                int weight = sc.nextInt();
                list[from].add(new Node(to, weight));
            }
        }

        // 임의의 노드(1)에서 가장 먼 노드를 찾아 node에 저장한다.
        visited = new boolean[v + 1];
        dfs(1, 0);

        visited = new boolean[v + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    static void dfs(int x, int len) {
        if (len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for (int i = 0; i < list[x].size(); i++) {
            Node cur = list[x].get(i);
            if (!visited[cur.num]) {
                dfs(cur.num, cur.weight + len);
                visited[cur.num] = true;
            }
        }
    }

    static class Node {
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }
    }

}