package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하라
 * 주어지는 연산자의 갯수는 차례대로 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수이다.
 *
 * [문제 풀이]
 * 주어진 연산자의 갯수에 따라 가능한 순열을 구한다
 */
public class BOJ_14888_연산자끼워넣기 {

    static int N;
    static int[] nums, operators, output;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());  // 수의 갯수
        nums = new int[N];  // 주어진 수의 배열
        operators = new int[N-1];  // 주어진 각 연산자들의 갯수
        visited = new boolean[N-1];  // 순열에 특정 인덱스의 수가 포함되었는지 나타내는 배열
        output = new int[N-1];  // 순열 생성의 결과

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0) {
                operators[idx++] = i;
            }
        }

        dfs(0);
//        System.out.println(max);
//        System.out.println(min);
    }

    private static void dfs(int depth) {
        if (depth == N-1) {
            for(int i : output) {
                System.out.print(i + " ");
            }
            System.out.println();

            // 최댓값, 최솟값 갱신
            int result = calc();
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i < N-1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = operators[i];
                dfs(depth+1);
                visited[i] = false;
            }
        }
    }

    /**
     * 생성된 연산자의 순열에 따라 결과값을 계산하여 반환한다
     * @return 계산의 결과
     */
    private static int calc() {
        int result = nums[0];

        for (int i = 0; i < output.length; i++) {
            switch (output[i]) {
                case 0:  // 더하기
                    result += nums[i+1];
                    break;
                case 1:  // 빼기
                    result -= nums[i+1];
                    break;
                case 2:  // 곱하기
                    result *= nums[i+1];
                    break;
                case 3:  // 나누기
                    result /= nums[i+1];
            }
        }

        return result;
    }

}