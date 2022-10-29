package math.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int k = 0; k < M; k++) {
                    arr[j][k] += Integer.parseInt(st.nextToken());
                }
            }
        }

        int[][] arr_result = new int[N][M];
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                sb.append(arr[j][k]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}