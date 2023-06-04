package recursion.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
    static int[][] img;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        img = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                img[i][j] = s.charAt(j) - '0';
            }
        }

        solution(0, 0, N);
        System.out.println(sb);
    }

    static void solution(int x, int y, int size) {
        if (isConsistent(x, y, size)) {
            sb.append(img[x][y]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');

        solution(x, y, newSize);
        solution(x, y+newSize, newSize);
        solution(x+newSize, y, newSize);
        solution(x+newSize, y+newSize, newSize);

        sb.append(')');
    }

    static boolean isConsistent(int x, int y, int size) {
        int firstValue = img[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (img[i][j] != firstValue) {
                    return false;
                }
            }
        }

        return true;
    }
}