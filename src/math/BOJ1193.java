package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        System.out.println(solution(X));
    }

    public static String solution(int n) {
        int numerator = 0;
        int denominator = 0;

        int level = 1;
        int start = 1;


        while (true) {

            if (n <= start + level - 1) {
                if(level % 2 == 1) {  // 홀수번째 레벨일 때
                    numerator = level - (n - start);
                    denominator = 1 + (n - start);
                    break;
                }
                else {  // 짝수번째 레벨일 때
                    numerator = 1 + (n - start);
                    denominator = level - (n - start);
                    break;
                }
            }

            start += level;
            level++;
        }

        return new String(numerator+"/"+denominator);
    }
}
