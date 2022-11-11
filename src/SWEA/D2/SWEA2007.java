package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            String S = br.readLine();
            for (int i = 1; i < S.length(); i++) {
                String a = S.substring(0, i);
                String b = S.substring(i, i + i);
                String c = S.substring(i+i, i*3);

                if (a.equals(b) && a.equals(c)) {
                    sb.append("#").append(t).append(" ").append(a).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}