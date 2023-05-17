package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B));
    }

    static int bfs(int from, int to) {
        Queue<Long> que = new LinkedList<>();
        que.add((long) from);

        int cnt = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            for (int i = 0; i < size; i++) {
                long num = que.poll();

                if (num == to) {
                    return cnt + 1;
                }

                if (num*2 <= to) {
                    que.add(num*2);
                }
                if (num*10 + 1 <= to) {
                    que.add(num*10 + 1);
                }
            }

            cnt++;
        }

        return -1;
    }

}