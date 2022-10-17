package implementation;

import java.io.IOException;
import java.util.Scanner;

public class BOJ11720 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String a = sc.next();
        sc.close();

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += a.charAt(i) - '0';  // char형으로 된 수를 그 숫자 자체로 사용하기 위해 '0' 혹은 48을 빼주어야 한다
        }

        System.out.println(sum);
    }
}
