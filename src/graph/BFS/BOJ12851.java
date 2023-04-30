package graph.BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {
    static int N, K;
    static int[] visit = new int[100001];
    static int minTime = 987654321;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 수빈이가 동생보다 오른쪽에 있는 경우
        if (N >= K) {
            System.out.println((N - K) + "\n1");
        }
        else {
            bfs(N);
            System.out.println(minTime+"\n"+count);
        }


    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        visit[node] = 1;  // 처음 위치(t = 0) 입력

        while (!q.isEmpty()) {
            int now = q.poll();

            // n 위치에 도달한 시간
            if (minTime < visit[now]) return;

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0)         next = now + 1;
                else if (i == 1)    next = now - 1;
                else                next = now * 2;

                if (next < 0 || next > 100000) continue;

                if (next == K) {
                    minTime = visit[now];
                    count++;
                }

                // 첫 방문이거나
                // 이미 방문한 곳이라도
                if (visit[next] == 0 || visit[next] == visit[now] + 1) {
                    q.add(next);
                    visit[next] = visit[now] + 1;
                }
            }

        }
    }
}
