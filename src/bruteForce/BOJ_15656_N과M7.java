package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 주어진 N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러번 골라도 된다
 *
 * 중복되는 수열을 여러 번 출력하면 안되며,
 * 수열은 사전 순으로 증가하는 순서로 출력해야 한다
 */
public class BOJ_15656_N과M7 {

    static int N, M;
    static int[] nums;
    static int[] output; // 한 줄에 출력할 하나의 수열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solution();
        System.out.println(sb);
    }

    private static void solution() {
        Arrays.sort(nums);  // 수열의 사전순 출력을 위한 오름차순 정렬

        output = new int[M];  // 한 줄에 출력할 하나의 수열

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            print();
            return;
        }

        for (int i = 0; i < N; i++) {
            output[depth] = nums[i];
            dfs(depth+1);
        }
    }

    private static void print() {
        for (int i = 0; i < M; i++) {
            sb.append(output[i]).append(' ');
        }
        sb.append('\n');
    }

}
