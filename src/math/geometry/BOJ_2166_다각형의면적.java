package math.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2166_다각형의면적 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] arrX = new long[N+1];
        long[] arrY = new long[N+1];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arrX[i] = Integer.parseInt(st.nextToken());
            arrY[i] = Integer.parseInt(st.nextToken());
        }

        arrX[N] = arrX[0];  // 마지막 위치에 첫번째 값을 대입
        arrY[N] = arrY[0];

        // 신발끈 공식의 확장 - 다각형을 여러개의 삼각형으로 분할
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += arrX[i]*arrY[i+1];
            sum2 += arrX[i+1]*arrY[i];
        }

        System.out.printf("%.1f", Math.abs(sum1 - sum2)/2.0);
    }

}