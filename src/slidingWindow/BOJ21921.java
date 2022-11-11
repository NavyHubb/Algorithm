package slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max;
        int count = 1;
        
        // 첫날부터 X일 동안의 방문자 수를 max의 초기값으로 설정
        for (int i = 0; i < X; i++) {
            sum += arr[i];
        }
        max = sum;

        // 슬라이딩 윈도우 기법
        for (int i = X; i < N; i++) {
            sum -= arr[i - X];  // 기간 내 첫번째 날의 값 빼기
            sum += arr[i];  // 기간 내 마지막 날의 다음 날의 값 더하기

            // 최댓값 값 갱신
            if (sum > max) {
                count = 0;
                count++;
                max = sum;
            }
            // 최댓값과 같은 값이 나오면 카운팅
            else if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max + "\n" + count);
    }
}