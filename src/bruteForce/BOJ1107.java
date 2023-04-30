package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1107 {
    final static int initial = 100;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());  // 이동하려는 채널
        int M = Integer.parseInt(br.readLine());  // 고장난 버튼 개수

        int result;

        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean[] broken = new boolean[10];  // 고장난 버튼이면 true
            for (int i = 0; i < M; i++) {
                int n = Integer.parseInt(st.nextToken());
                broken[n] = true;
            }

            result = Math.abs(target - initial);
            for (int i = 0; i <= 999_999; i++) {  // target의 최댓값이 500,000이므로 여섯자리 수의 최댓값인 999,999까지 탐색
                String str = String.valueOf(i);
                int len = str.length();

                boolean isBreak = false;
                for (int j = 0; j < len; j++) {
                    // 고장난 버튼의 번호가 target에 포함된 경우
                    if (broken[str.charAt(j) - '0']) {
                        isBreak  = true;
                        break;
                    }
                }

                // 고장난 버튼의 번호가 target에 포함되지 않은 경우
                if (!isBreak) {
                    int min = len + Math.abs(target - i);  // target의 자릿수만큼의 버튼을 누르고, 그 번호에서 target까지의 차이만큼 더 눌러준다
                    result = Math.min(min, result);
                }
            }
        }
        // 고장난 버튼이 없는 경우
        else {
            result = Math.min(String.valueOf(target).length(), Math.abs(target - initial));
        }

        System.out.println(result);
    }
}