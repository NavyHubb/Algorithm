package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int x = a * b * c;
        String stringX = Integer.toString(x);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < stringX.length(); j++) {
                cnt = 0;
                char charI = (char) (i + '0');
                if (stringX.charAt(j) == charI) cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

    }
}
