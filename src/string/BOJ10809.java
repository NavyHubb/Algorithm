package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 97; i < 123; i++) {  // a 부터 z 까지
            sb.append(findIndex(S, i)).append(" ");
        }

        System.out.println(sb);
    }

    public static int findIndex(String S, int n) {
        int idx = -1;

        for (int j = 0; j < S.length(); j++) {
            if (S.charAt(j) == n) {
                idx = j;
                break;
            }
        }

        return idx;
    }
}
