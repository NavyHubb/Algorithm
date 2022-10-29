package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {

    static boolean[][] arr;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            for (int j = 0; j < M; j++) {
                if (S.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    public static void find(int x, int y) {
        int count = 0;  // 바꿔야 될 칸의 갯수를 센다

        boolean TF = arr[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                // 올바른 색이 아닐 경우 count 1 증가
                if (arr[i][j] != TF) {
                    count++;
                }

                // 다음 칸은 색이 바뀌어야 하므로 값 변경
                TF = (!TF);
            }
            TF = (!TF);
        }

        // 첫번째 칸을 W로 할 때와 B로 할 때 사이에서 count가 더 작은 것으로 저장
        count = Math.min(count, 64 - count);

        min = Math.min(min, count);
    }
}