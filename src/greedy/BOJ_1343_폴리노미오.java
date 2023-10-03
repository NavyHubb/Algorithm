package greedy;

import java.util.Scanner;

public class BOJ_1343_폴리노미오 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder sb = new StringBuilder();

        String A = "AAAA";
        String B = "BB";

        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                cnt++;
            } else {
                if (cnt%2 != 0) {
                    System.out.println(-1);
                    System.exit(0);
                }

                if (cnt > 0) {
                    while (cnt >= 4) {
                        sb.append(A);
                        cnt -= 4;
                    }

                    while (cnt > 0 && cnt%2 == 0) {
                        sb.append(B);
                        cnt -= 2;
                    }
                }

                sb.append('.');
                cnt = 0;
            }
        }

        if (cnt%2 != 0) {
            System.out.println(-1);
            System.exit(0);
        }

        if (cnt > 0) {
            while (cnt >= 4) {
                sb.append(A);
                cnt -= 4;
            }

            while (cnt > 0 && cnt%2 == 0) {
                sb.append(B);
                cnt -= 2;
            }
        }

        System.out.println(sb);
    }

}