package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int temp = n;
        int count = 0;

        while (true) {
            int left = temp / 10; // 십의 자리 숫자: 10으로 나누었을 때의 몫
            int right = temp % 10; // 일의 자리 숫자: 10으로 나누었을 때의 나머지
            temp = (right * 10) + (left + right) % 10;
            count++;

            if (n == temp) break;
        }
        System.out.println(count);
    }
}
