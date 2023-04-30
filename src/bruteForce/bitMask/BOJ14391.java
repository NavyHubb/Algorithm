package bruteForce.bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14391 {
    static int N, M;
    static int paper[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 세로 길이
        M = Integer.parseInt(st.nextToken());  // 가로 길이
        paper = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                paper[i][j] = str.charAt(j) - '0';  // char 형으로된 숫자를 int형으로 변환
            }
        }

        int answer = 0;

        for (int s = 0; s < (1 << (N * M)); s++) {
            int sum = 0;

            // 가로(0) 찾기
            for (int i = 0; i < N; i++) {
                int cur = 0;

                for (int j = 0; j < M; j++) {
                    int k = i * M + j;  // k는 paper[i][j]

                    // s의 k번째 비트가 0이면
                    if ((s & (1 << k)) == 0) {
                        cur *= 10;
                        cur += paper[i][j];
                    }
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            // 세로(1) 찾기
            for (int j = 0; j < M; j++) {
                int cur = 0;

                for (int i = 0; i < N; i++) {
                    int k = i * M + j;

                    if ((s & (1 << k)) != 0) {
                        cur *= 10;
                        cur += paper[i][j];
                    }
                    else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}