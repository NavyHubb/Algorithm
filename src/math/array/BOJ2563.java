package math.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int area = 300;  // 색종이 세 장의 넓이 합

        // 이 문제의 핵심 키워드는 '2차원 배열'이다
        // 흰 도화지를 가로1, 세로1인 모눈으로 나누고 색종이가 붙여진 부분을 1로 값을 매겨준다
        // 결과적으로 1인 값들의 합이 색종이가 붙여진 면적이다
        int[][] arr = new int[100][100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                sum += arr[i][j];
            }
        }

        System.out.println(sum);
    }
}