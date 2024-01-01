package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 주어진 sign matrix를 만족하는 정수들의 조합을 구하라
 * 정수 n은 -10 <= n <= 10 을 만족한다
 *
 * [문제 풀이]
 * DFS를 통해 sign matrix를 만족하는 정수의 배열을 완성한다
 */
public class BOJ_1248_guess {

    static int N;
    static Character[][] map;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new Character[N][N];
        output = new int[N];
        String str = br.readLine();
        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                map[i][j] = str.charAt(idx++);
            }
        }

        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            for (int i : output) {
                sb.append(i).append(' ');
            }
            System.out.println(sb);

            System.exit(0);
        }

        for (int i = -10; i <= 10; i++) {
            output[depth] = i;
            if (check(depth)) {
                dfs(depth+1);
            }
        }
    }

    private static boolean check(int length) {
        for (int i = 0; i <= length; i++) {
            int sum = 0;
            for (int j = i; j <= length; j++) {
                sum += output[j];
                if (map[i][j] != ((sum == 0) ? '0' : (sum > 0) ? '+' : '-')) return false;
            }
        }
        return true;
    }

    private static void print() {

    }
}
