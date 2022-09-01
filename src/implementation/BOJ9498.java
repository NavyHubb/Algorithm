package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9498 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        System.out.println(grade(score));
    }

    public static String grade(int score) {
        String answer;
        if (score <= 100 && score >= 90) {
            answer = "A";
        } else if (score >= 80) {
            answer = "B";
        } else if (score >= 70) {
            answer = "C";
        } else if (score >= 60) {
            answer = "D";
        } else {
            answer = "F";
        }
        return answer;
    }
}
