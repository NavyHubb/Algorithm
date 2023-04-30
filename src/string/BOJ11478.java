package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < s.length() ; i++) {
            for (int j = 1; j <= s.length(); j++) {
                if (i + j <= s.length()) {
                    set.add(s.substring(i, i + j));
                }
                else break;
            }
        }

        System.out.println(set.size());
    }
}