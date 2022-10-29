package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int H = Integer.parseInt(st.nextToken());  // 세로
            int W = Integer.parseInt(st.nextToken());  // 가로
            int N = Integer.parseInt(st.nextToken());  // N번째 손님

            // 방번호
            int Y = 0;
            int X = 0;
            if (N % H != 0) {
                Y = N % H;
                X = (N / H) + 1;
            }
            else {
                Y = H;
                X = N / H;
            }

            // 문자열로 변환
            if (X < 10) {
                sb.append(Y).append("0").append(X).append("\n");
            }
            else {
                sb.append(Y).append(X).append("\n");
            }
        }

        System.out.println(sb);
    }
}