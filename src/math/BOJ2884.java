package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m - 45 < 0) {
            if (h == 0) {
                h = 23;
                m = 60 + (m - 45);
            }
            else {
                h -= 1;
                m = 60 + (m - 45);
            }
        }
        else {
            m -= 45;
        }
        System.out.println(h+" "+m);
    }
}
