package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        if (b + c >= 60) {
            a += (b+c)/60;

            if (a >=24) {
                a -= 24;
            }

            int q = (b+c)/60;
            b = b + c - 60*q;
        } else {
            b = b + c;
        }

        System.out.println(a+" "+b);
    }
}
