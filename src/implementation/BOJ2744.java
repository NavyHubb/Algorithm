package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c >= 65 && c <= 90) {  // 아스키 코드 상에서 대문자 알파벳의 범위: 65 ~90
                c += 32;  // 대문자를 소문자로 변환
                sb.append((char) c);  // int형을 char형으로 형변환
            }
            else {
                c -= 32;  // 소문자를 대문자로 변환
                sb.append((char) c);
            }
        }

        System.out.println(sb);
    }
}