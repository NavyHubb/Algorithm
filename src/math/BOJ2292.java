package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }

    public static int solution(int n) {

        if (n == 1) return 1;

        int i = 1;
        int num = 2;  // 두번째 층위의 시작 수

        while (num <= n) {
            num += 6*i++;
        }

        return i;
    }
}