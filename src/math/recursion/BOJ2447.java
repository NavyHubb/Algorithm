package math.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2447 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        star(0, 0, N, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void star(int x, int y, int N, boolean blank) {

        // 공백칸일 경우
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';  // 별을 찍지 않고 공백을 둔다
                }
            }
            return;
        }

        // 더 이상 분할할 수 없는 블록일 경우(한변의 길이가 3일 경우)
        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        int size = N / 3;  // 전체를 3*3 블록으로 나눴을 때 한 블록의 변의 길이는 전체였을 때의 변의 길이의 1/3
        int count = 0;  // 몇번째 블록인지를 나타내는 인덱스
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;

                if (count == 5) {  // 공백칸일 경우
                    star(i, j, size, true);
                }
                else {
                    star(i, j, size, false);
                }
            }
        }
    }
}