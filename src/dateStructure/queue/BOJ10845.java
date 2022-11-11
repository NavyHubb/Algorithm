package dateStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10845 {
    public static int[] queue;
    public static int size = 0;
    public static int begin = 0;
    public static int end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        queue = new int[N];

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(pop()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void push(int item) {
        queue[end] = item;
        end++;
    }

    public static int pop() {
        if (begin == end) {
            return -1;
        }
        else {
            int result = queue[begin];
            queue[begin] = 0;
            begin++;

            return result;
        }
    }

    public static int size() {
        return end - begin;
    }

    public static int empty() {
        if (begin == end) {
            return 1;
        }
        else return 0;
    }

    public static int front() {
        if (begin == end) {
            return -1;
        } else {
            return queue[begin];
        }
    }

    public static int back() {
        if (begin == end) {
            return -1;
        } else {
            return queue[end - 1];
        }
    }
}