package graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
    static int L;
    static int C;
    static char[] set;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        set = new char[C];
        arr = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            set[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(set);

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {
        if (depth == L) {
            if (isValid()) {
                sb.append(arr).append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            arr[depth] = set[i];
            dfs(i + 1, depth + 1);
        }
    }

    public static boolean isValid() {
        int consonant = 0;
        int vowel = 0;

        for (char x : arr) {
            if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u') {
                vowel++;
            }
            else {
                consonant++;
            }
        }

        if (vowel >= 1 && consonant >= 2) {
            return true;
        }
        return false;
    }
}