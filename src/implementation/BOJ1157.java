package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();  // 일괄 대문자화

        int[] arrFrequency = new int[26];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 65; j < 91; j++) {
                arrFrequency[s.charAt(i) - 65]++;  // A의 코드값이 65
            }
        }

        int max = -1;
        char c = '?';
        for (int i = 0; i < 26; i++) {
            if (arrFrequency[i] > max) {
                max = arrFrequency[i];
                c = (char) (i + 65);
            } else if (arrFrequency[i] == max){
                c = '?';
            }
        }

        System.out.println(c);
    }
}
