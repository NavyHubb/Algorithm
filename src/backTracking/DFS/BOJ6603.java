package backTracking.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6603 {
    public static int k;
    public static int[] set;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) {
                break;
            }

            st = new StringTokenizer(s);
            k = Integer.parseInt(st.nextToken());

            set = new int[k];
            arr = new int[6];
            for (int i = 0; i < k; i++) {
                set[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < k; i++) {
            arr[depth] = set[i];
            dfs(i + 1, depth + 1);
        }
    }
}