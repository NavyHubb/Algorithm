package contest.kakaoCodeFestival2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(priceFirst(a) + priceSecond(b)).append("\n");
        }

        System.out.println(sb);
    }

    // 1회 페스티벌 상금
    static int priceFirst(int rank) {
        if (rank > 21 || rank <= 0) {
            return 0;
        }

        if (rank == 1) return 5000000;
        else if (rank <= 3) return 3000000;
        else if (rank <= 6) return 2000000;
        else if (rank <= 10) return 500000;
        else if (rank <= 15) return 300000;
        else return 100000;
    }

    // 2회 페스티벌 상금
    static int priceSecond(int rank) {
        if (rank > 31 || rank <= 0) {
            return 0;
        }

        if (rank == 1) return 5120000;
        else if (rank <= 3) return 2560000;
        else if (rank <= 7) return 1280000;
        else if (rank <= 15) return 640000;
        else return 320000;
    }
}