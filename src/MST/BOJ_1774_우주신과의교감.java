package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1774_우주신과의교감 {

    static int N, M;
    static int[][] locs;
    static int[] start;
    static class Node {
        int to;
        float weight;

        public Node(int to, float weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        locs = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            locs[i][0] = Integer.parseInt(st.nextToken());
            locs[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        start = new int[2];
        start[0] = Integer.parseInt(st.nextToken());
        start[1] = Integer.parseInt(st.nextToken());

        System.out.printf("%f.2", solution(start));
    }

    static float solution(int[] start) {
        float weightSum = getDist(locs[start[0]], locs[start[1]]);

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (int) (o1.weight - o2.weight));
        boolean[] visited = new boolean[N+1];

        visited[start[0]] = true;
        visited[start[1]] = true;

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            pq.add(new Node(i, getDist(locs[start[0]], locs[i])));
        }
        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;

            pq.add(new Node(i, getDist(locs[start[1]], locs[i])));
        }

        int cnt = 1;
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.to]) continue;

            cnt++;
            visited[cur.to] = true;
            weightSum += cur.weight;

            if (cnt == N) return weightSum;

            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;

                pq.add(new Node(i, getDist(locs[cur.to], locs[i])));
            }
        }

        return weightSum;
    }

    static float getDist(int[] loc1, int[] loc2) {
        return (float) Math.sqrt(Math.pow(loc1[0] - loc2[0], 2) + Math.pow(loc1[1] - loc2[1], 2));
    }
}
