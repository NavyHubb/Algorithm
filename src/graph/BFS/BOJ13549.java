package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549 {
    static int N;
    static int K;
    static int[] times = new int[100_001];
    static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N-K);
            return;
        }

        bfs();
        System.out.println(minTime-1);
    }

    static void bfs() {
        minTime = 0;

        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        times[N] = 1;

        while (!que.isEmpty()) {
            int now = que.poll();

            if (now == K) {
                minTime = times[now];
            }

            int next = now*2;  // 순간이동
            if (next <= 100_000) {
                if (times[next] == 0 || times[next] > times[now]) {
                    que.add(next);
                    times[next] = times[now];
                }
            }

            // 앞 혹은 뒤로 한칸 이동
            for (int i = 0; i < 2; i++) {
                if (i == 0) next = now-1;
                else next = now+1;

                if (next < 0 || next > 100_000) continue;

                if (times[next] == 0 || times[next] > times[now] + 1) {
                    que.add(next);
                    times[next] = times[now] + 1;
                }
            }

        }
    }

}