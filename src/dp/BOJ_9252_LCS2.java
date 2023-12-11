package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제
 *
 *   ACAYKP
 * C 011111
 * A 112222
 * P 112223
 * C 122223
 * A 123333
 * K 123344
 */
public class BOJ_9252_LCS2 {

    static char[] X, Y;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Y = br.readLine().toCharArray();
        X = br.readLine().toCharArray();

        solution();
        System.out.println(sb);
    }

    static void solution() {
        int lenX = X.length;
        int lenY = Y.length;

        int[][] dp = new int[lenX+1][lenY+1];

        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                if (X[i-1] == Y[j-1]) {  // 같은 문자가 등장한 경우
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        sb.append(dp[lenX][lenY]).append('\n');

        Stack<Character> stack = new Stack<>();
        int i = lenX;
        int j = lenY;
        while (i != 0 && j!= 0) {
            // 좌측과 상측 중 현재위치와 같은 칸으로 이동
            if (dp[i][j] == dp[i-1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j-1]) {
                j--;
            } else {  // 좌측상단 대각선으로 이동
                stack.push(X[i-1]);
                i--;
                j--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
