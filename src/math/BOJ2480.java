package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class BOJ2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        int [] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sort(arr); // 오름차순 정렬
        if (arr[0] == arr[2]) { // 오름차순 정렬에서 첫번째수와 마지막수가 같다는 것은 배열 내 모든 수가 같음을 의미
            answer += 10000 + arr[0]*1000;
        } else if (arr[0] == arr[1]) {
            answer += 1000 + arr[0]*100;
        } else if (arr[1] == arr[2]) {
            answer += 1000 + arr[1]*100;
        } else {
            answer += arr[2]*100;
        }

        System.out.println(answer);
    }
}
