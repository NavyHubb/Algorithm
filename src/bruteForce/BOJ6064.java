package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = M * N / gcd(M, N);  // 최소공배수
            int n = 0;
            int ans = -1;

            while (n * M < lcm) {
                if (((n * M + x) - y) % N == 0) {
                    ans = n * M + x;
                    break;
                }

                n++;
            }

            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    // 최대공약수 - 유클리드 호제법
    static int gcd(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }
}