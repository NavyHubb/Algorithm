package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            bfs(from, to);
        }
    }

    static void bfs(int from, int to) {
        String[] cmd = new String[10000];
        boolean[] visited = new boolean[10000];
        Queue<Integer> q = new LinkedList<>();
        q.offer(from);
        visited[from] = true;

        Arrays.fill(cmd, "");

        while (!q.isEmpty() && !visited[to]) {
            int cur = q.poll();
            int D = (2*cur) % 10000;
            int S = (cur == 0) ? 9999 : cur - 1;
            int L = (cur % 1000) * 10 + cur / 1000;
            int R = (cur % 10) * 1000 + (cur / 10);

            if (!visited[D]) {
                q.offer(D);
                visited[D] = true;
                cmd[D] = cmd[cur] + "D";
            }
            if (!visited[S]) {
                q.offer(S);
                visited[S] = true;
                cmd[S] = cmd[cur] + "S";
            }
            if (!visited[L]) {
                q.offer(L);
                visited[L] = true;
                cmd[L] = cmd[cur] + "L";
            }
            if (!visited[R]) {
                q.offer(R);
                visited[R] = true;
                cmd[R] = cmd[cur] + "R";
            }
        }

        System.out.println(cmd[to]);
    }
}
// 레지스터 명령어