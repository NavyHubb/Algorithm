package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * [문제 분석]
 * 빌딩의 개수: 1 ≤ N ≤ 80,000
 * 각 빌딩의 높이: 1 ≤ h ≤ 1,000,000,000
 *
 * [문제 풀이]
 *
 */
public class BOJ_6198_옥상정원꾸미기 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            // 스택 내에 현재 수 n 이하의 수를 추출해내고
            // n을 삽입한다
            while (!stack.isEmpty() && n >= stack.peek()) {
                stack.pop();
            }
            stack.push(n);

            result += stack.size()-1;
        }

        System.out.println(result);
    }

}