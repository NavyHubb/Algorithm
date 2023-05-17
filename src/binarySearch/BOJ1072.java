package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    static BufferedReader br;
    static StringTokenizer st;
    static int X;
    static int Y;
    static int Z;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        Z = getPercent(X, Y);
        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        int lo = 0;
        int hi = X * 2;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            // mid 값에 대해 변화가 생기는 경우
            // 값을 더 줄여도 된다
            if (getPercent(X+mid, Y+mid) != Z) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }

    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }

}