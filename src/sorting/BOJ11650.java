package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
           if (e1[0] == e2[0]) {  // arr[0] 이 x값, arr[1]이 y값
               return e1[1] - e2[1];  // 리턴되는 값이 양수일 경우 위치가 바뀌고, 음수일 경우 바뀌지 않음
           } else {
               return e1[0] - e2[0];
           }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0]+" "+arr[i][1]).append("\n");
        }

        System.out.println(sb);
    }
}