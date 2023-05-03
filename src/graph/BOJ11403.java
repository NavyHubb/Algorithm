package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][];
        for (int i = 0; i < N; i++) {
            data[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        solution(N, data);
    }

    static void solution(int v, int[][] data) {
        int[][] connect = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (data[i][j] == 1) {
                    connect[i][j] = 1;
                }
            }
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (connect[i][k] == 1 && connect[k][j] == 1) {
                        connect[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                sb.append(connect[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}