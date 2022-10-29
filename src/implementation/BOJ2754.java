package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2754 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        double score = 0;

        if (S.charAt(0) == 'A') {
            score = 4.0;
            if (S.charAt(1) == '+') {
                score += 0.3;
            }
            else if (S.charAt(1) == '-') {
                score -= 0.3;
            }
        }
        else if (S.charAt(0) == 'B') {
            score = 3.0;
            if (S.charAt(1) == '+') {
                score += 0.3;
            }
            else if (S.charAt(1) == '-') {
                score -= 0.3;
            }

        }
        else if (S.charAt(0) == 'C') {
            score = 2.0;
            if (S.charAt(1) == '+') {
                score += 0.3;
            }
            else if (S.charAt(1) == '-') {
                score -= 0.3;
            }

        }
        else if (S.charAt(0) == 'D') {
            score = 1.0;
            if (S.charAt(1) == '+') {
                score += 0.3;
            }
            else if (S.charAt(1) == '-') {
                score -= 0.3;
            }
        }

        System.out.printf("%.1f", score);
    }
}