package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.toString(i);
            arr[i][1] = st.nextToken();
            arr[i][2] = st.nextToken();
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1[1].equals(e2[1])) {  // 나이가 같을 때
                return Integer.parseInt(e1[0]) - Integer.parseInt(e2[0]);
            } else {
                return Integer.parseInt(e1[1]) - Integer.parseInt(e2[1]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][1]).append(" ").append(arr[i][2]).append("\n");
        }

        System.out.println(sb);
    }
}