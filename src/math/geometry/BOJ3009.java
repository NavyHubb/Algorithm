package math.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3009 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] x = new int[3];  // 각 점의 x축 좌표값
        int[] y = new int[3];  // 각 점의 y축 좌표값

        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(x)+" "+solution(y));
    }

    // 주어진 배열에서 쌍을 이루지 않는 값 반환
    static int solution(int[] arr) {
        if (arr[0] == arr[1]) {
            return arr[2];
        }
        else if (arr[1] == arr[2]) {
            return arr[0];
        }
        else {
            return arr[1];
        }
    }
}