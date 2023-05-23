package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] matA = new char[N][];
        char[][] matB = new char[N][];

        for (int i = 0; i < N; i++) {
            matA[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < N; i++) {
            matB[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < N-2; i++) {
            for (int j = 0; j < M-2; j++) {
                if (matA[i][j] != matB[i][j]) {
                    cnt++;

                    for (int k = i; k < i+3; k++) {
                        for (int l = j; l < j+3; l++) {
                            matA[k][l] = matA[k][l] == '1' ? '0' : '1';
                        }
                    }
                }
            }
        }

        boolean flag = true;
        Loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matA[i][j] != matB[i][j]) {
                    flag = false;
                    break Loop;
                }
            }
        }

        System.out.println(flag ? cnt : -1);
    }
}