package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1958_LCS3 {

    static char[] X, Y, Z;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        X = br.readLine().toCharArray();
        Y = br.readLine().toCharArray();
        Z = br.readLine().toCharArray();

        solution();
    }

    static void solution() {
        int lenX = X.length;
        int lenY = Y.length;
        int lenZ = Z.length;

        int[][][] dp = new int[lenX+1][lenY+1][lenZ+1];

        for (int i = 1; i <= lenX; i++) {
            for (int j = 1; j <= lenY; j++) {
                for (int k = 1; k <= lenZ; k++) {
                    if (X[i-1] == Y[j-1] && Y[j-1] == Z[k-1]) {  // 같은 문자가 등장한 경우
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k],  dp[i][j][k-1]));
                    }
                }
            }
        }

        System.out.println((dp[lenX][lenY][lenZ]));
    }
}
