package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = 1, s = 1, m = 1;
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int year = 1;;year++) {  // 조건식 부분을 생략함으로써 무한루프 생성
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            e++;
            s++;
            m++;

            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;
        }
    }
}