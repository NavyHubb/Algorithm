package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 같은 수를 여러번 골라도 된다
 * => 중복 순열
 * 단, 같은 수열을 여러번 출력하는 것은 안된다
 *
 */
public class BOJ_15651_N과M3 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] output; // 한 줄에 출력할 하나의 수열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        solution();
        System.out.println(sb);
    }

    private static void solution() {
        output = new int[M];  // 한 줄에 출력할 하나의 수열

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            print();
            return;
        }

        for (int i = 0; i < N; i++) {
            output[depth] = i+1;
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
