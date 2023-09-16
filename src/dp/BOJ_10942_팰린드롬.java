package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10942_팰린드롬 {

    static int N;
    static int[] nums;
    static boolean[][] dp;  // dp[i][j] : i ~ j 번째 수가 팰린드롬이면 true
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new int[N+1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp = new boolean[N+1][N+1];

        solution();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(dp[from][to] ? 1 : 0).append('\n');
        }

        System.out.println(sb);
    }

    static void solution() {
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }

        for (int i = 1; i <= N-1; i++) {
            if (nums[i] == nums[i+1]) {
                dp[i][i+1] = true;
            }
        }

        for (int l = 2; l < N; l++) {  // l: 팰린드롬인지 검사할 문자열의 시작 인덱스와 끝 인덱스의 차이. 즉, (팰린드롬의 길이 - 1)
            for (int i = 1; i <= N-l; i++) {  // i: 검사할 문자열의 시작 인덱스
                if (nums[i] == nums[i+l] && dp[i+1][i+l-1]) {
                    dp[i][i+l] = true;
                }
            }
        }
    }

}
