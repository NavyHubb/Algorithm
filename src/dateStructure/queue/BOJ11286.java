package dateStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> posQ = new PriorityQueue<>();
        PriorityQueue<Integer> negQ = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int x = Integer.parseInt(br.readLine());

            if (x != 0) {
                if (x > 0) {
                    posQ.offer(x);
                } else {
                    negQ.offer(x);
                }
            } else {
                int pos = posQ.isEmpty() ? 0 : posQ.peek();
                int neg = negQ.isEmpty() ? 0 : negQ.peek();

                if (posQ.isEmpty() && negQ.isEmpty()) {
                    sb.append(0).append('\n');
                } else if (!posQ.isEmpty() && negQ.isEmpty()) {
                    sb.append(pos).append('\n');
                    posQ.poll();
                } else if (posQ.isEmpty() && !negQ.isEmpty()) {
                    sb.append(neg).append('\n');
                    negQ.poll();
                } else {
                    if (pos >= Math.abs(neg)) {
                        sb.append(neg).append('\n');
                        negQ.poll();
                    } else {
                        sb.append(pos).append('\n');
                        posQ.poll();
                    }
                }
            }
        }

        System.out.println(sb);
    }
}