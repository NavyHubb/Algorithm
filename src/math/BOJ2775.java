package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2775 {

    /**
     * k, n 값을 입력받을 때마다 그 크기에 맞는 배열을 생성하기보다
     * 입력의 최댓값까지를 수용할 수 있는 배열을 한번만 만들어서
     * 계속 사용할 수 있도록 하였다
     */
    public static int[][] APT = new int[15][15];  // 주어진 조건: 1 ≤ k, n ≤ 14

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 아파트 생성(각 호수에 몇명이 사는지 모두 입력된 상태)
        make_APT();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());  // 층
            int n = Integer.parseInt(br.readLine());  // 호

            sb.append(APT[k][n]).append("\n");
        }

        System.out.println(sb);
    }

    public static void make_APT() {
        for (int i = 0; i < 15; i++) {
            APT[i][1] = 1;  // 각 층의 1호는 모두 1명
            APT[0][i] = i; // 0호는 없지만 구현의 편의를 위해 넣어준다
        }

        for (int i = 1; i < 15; i++) {  // 층
            for (int j = 2; j < 15; j++) {  // 1호는 첫번째 반복문에서 이미 입력했으니까 2호부터
                APT[i][j] = APT[i][j-1] + APT[i-1][j];
            }
        }
    }
}