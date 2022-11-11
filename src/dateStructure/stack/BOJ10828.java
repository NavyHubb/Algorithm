package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        stack = new int[N];

        while (N-- > 0){
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop" :
                    sb.append(pop()).append("\n");
                    break;

                case "size" :
                    sb.append(size()).append("\n");
                    break;

                case "empty" :
                    sb.append(empty()).append("\n");
                    break;

                case "top" :
                    sb.append(top()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void push(int item) {
        stack[size] = item;  // 인덱스 0에서부터 입력
        size++;
    }

    public static int pop() {
        if (size == 0) {
            return -1;
        }
        else {
            int item = stack[size - 1];  // pop의 대상
            stack[size - 1] = 0;  // pop 대상인 인덱스의 값을 초기화
            size--;
            return item;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if (size == 0) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int top() {
        if (size == 0) {
            return -1;
        }
        else {
            return stack[size - 1];
        }
    }
}