package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seq = new int[N];  // 입력값이 담길 수열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            // 스택이 비어있지 않으면서
            // 스택의 top 값보다 수열의 현재 값이 크면
            // 스택의 원소를 pop하면서, 수열에서 해당 인덱스의 값을 현재원소로 초기화
            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                seq[stack.pop()] = seq[i];
            }

            // 위의 while문을 돌며 스택을 모두 비우고 나서, 스택에 현재 인덱스를 push
            stack.push(i);
        }

        // 스택에 남아있는 값은 오큰수를 가지지 않는 수의 인덱스를 나타내므로 해당 인덱스에 -1 대입
        while (!stack.isEmpty()) {
            seq[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(seq[i]).append(' ');
        }

        System.out.println(sb);
    }
}