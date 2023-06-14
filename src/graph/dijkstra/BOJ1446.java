package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1446 {
    static int N, D;
    static final int INF = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> nodes = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodes.add(new Node(from, to, weight));
        }

        int[] dp = new int[D+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 1; i <= D; i++) {
            // 현재 위치가 지름길을 통해 올 수 있는 곳일 경우
            while (!nodes.isEmpty() && nodes.peek().to == i) {
                Node cur = nodes.poll();

                dp[i] = Math.min(dp[i], dp[cur.from] + cur.weight);
            }


            dp[i] = Math.min(dp[i], dp[i-1] + 1);
        }

        System.out.println(dp[D]);
    }

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return to - o.to;
        }
    }

}