package bruteForce.bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int count = 0;  // 조건을 만족하는 경우의 수

        // 배열 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 부분집합 전부 구하기
        for(int i = 1; i < (1<<arr.length); i++) {
            int sum = 0;  // 부분집합 원소들의 합

            for(int j = 0; j < arr.length; j++) {
                if((i & (1<<j)) != 0) {
                    sum += arr[j];
                }
            }

            if (sum == S) {
                count++;
            }
        }

        System.out.println(count);
    }
}