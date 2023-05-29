package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int aLen = A.length();
        int bLen = B.length();

        char[] arrA = new char[aLen+1];
        for (int i = 1; i <= aLen; i++) {
            arrA[i] = A.charAt(i-1);
        }
        char[] arrB = new char[B.length()+1];
        for (int i = 1; i <= bLen; i++) {
            arrB[i] = B.charAt(i-1);
        }

        int[][] dp = new int[aLen+1][bLen+1];
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (arrA[i] == arrB[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[aLen][bLen]);
    }
}