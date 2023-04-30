package dateStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ15828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        System.out.println(solution(N));
    }

    static String solution(int n) throws IOException {
        Queue<Integer> q = new LinkedList<>();

        while (true) {
            int pk = Integer.parseInt(br.readLine());

            if (pk == -1) {
                break;
            }

            if (q.size() != n) {
                if (pk != 0) {
                    q.offer(pk);
                }
                else {
                    q.poll();
                }
            }
            // 큐가 가득 찼을 경우
            else {
                if (pk == 0) {
                    q.poll();
                }
            }
        }

        if (q.isEmpty()) {
            return "empty";
        }
        else {
            StringBuilder sb = new StringBuilder();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                sb.append(q.poll()).append(' ');
            }

            return sb.toString();
        }
    }
}