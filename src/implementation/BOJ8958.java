package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char[] arr = s.toCharArray();
            int cumulativeCount = 0;  // 누적 횟수
            int point = 0;  // 총점수

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 'O') {
                    cumulativeCount++;
                    point += cumulativeCount;
                } else {
                    cumulativeCount = 0;  // 'X'가 나오면 누적 횟수 초기화
                }
            }

            System.out.println(point);
        }
    }
}
