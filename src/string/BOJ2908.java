package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int reverseA = reverse(Integer.parseInt(st.nextToken()));
        int reverseB = reverse(Integer.parseInt(st.nextToken()));

        System.out.println(Math.max(reverseA, reverseB));
    }

    public static int reverse(int n) {
        int hun = n / 100;
        int ten = (n / 10) % 10;
        int one = n % 10;

        return one*100 + ten*10 + hun;
    }
}
