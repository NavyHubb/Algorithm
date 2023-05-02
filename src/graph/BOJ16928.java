package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16928 {
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[101];
        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            board[from] = to;
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        int[] visited = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == 100) {
                return visited[100];
            }

            for (int i = 1; i <= 6; i++) {
                int next = cur + i;

                if (next > 100 || visited[next] != 0) {
                    continue;
                }

                if (visited[board[next]] == 0) {
                    queue.offer(board[next]);
                    visited[board[next]] = visited[cur] + 1;
                }
            }
        }

        return -1;
    }

}