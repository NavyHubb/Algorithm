package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();

        System.out.println(solution(N, M, s));
    }

    static int solution(int N, int M, String s) {
        int count = 0;
        int result = 0;

        char[] chars = s.toCharArray();

        for (int i = 1; i < M - 1; i++) {
            if (chars[i - 1] == 'I' && chars[i] == 'O' && chars[i + 1] == 'I') {
                count++;

                if (count == N) {
                    result++;
                    count--;  // 아래에서 i++으로 이동하므로 누적된 count에서 하나를 빼준다
                }

                i++;
            } else {
                count = 0;
            }


        }
        return result;
    }

}
// #반복 #포함