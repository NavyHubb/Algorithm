package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ5430 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        while (T-- > 0) {
            String cmds = br.readLine();
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }


            AC(cmds, deque);
        }

        System.out.println(sb);
    }

    static void AC(String cmds, ArrayDeque<Integer> deque) {
        boolean isRight = true;  // 좌에서 우로 읽는다

        for (char c : cmds.toCharArray()) {
            if (c == 'D') {
                if (deque.size() == 0) {
                    sb.append("error\n");
                    return;
                }

                if (isRight) {
                    deque.pollFirst();
                } else {
                    deque.pollLast();
                }
            } else {
                isRight = !isRight;
            }
        }

        makePrintString(deque, isRight);
    }

    static void makePrintString(ArrayDeque<Integer> deque, boolean isRight) {
        sb.append('[');

        if (deque.size() > 0) {
            if (isRight) {
                sb.append(deque.pollFirst());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            } else {
                sb.append(deque.pollLast());

                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            }
        }

        sb.append(']').append('\n');
    }

}