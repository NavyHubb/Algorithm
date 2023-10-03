package math;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_25314_코딩은체육과목입니다 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = N/4;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= cnt-1; i++) {
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb);
    }

}
