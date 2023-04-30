package dateStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(lastCard(N));
    }

    static int lastCard(int n) {
        Queue<Integer> q = new LinkedList<>();

        if (n == 1) {
            return 1;
        }

        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (true) {
            q.poll();
            if (q.size() == 1) {
                return q.peek();
            }
            else {
                q.offer(q.poll());
            }
        }
    }
}