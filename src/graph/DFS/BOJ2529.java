package graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2529 {

    static int N;
    static char[] arr = new char[10];  // 부등호는 최대 9개
    static boolean[] visited = new boolean[10];  // 0~9 체크
    static List<String> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        dfs("", 0);
        Collections.sort(ans);

        System.out.println(ans.get(ans.size() - 1));
        System.out.println(ans.get(0));
    }

    static void dfs(String num, int idx) {
        if (idx == N + 1) {  // 부등호가 N개라면 수는 N+1개
            ans.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (visited[i]) continue;
            if (idx == 0 || check(Character.getNumericValue(num.charAt(idx - 1)), i, arr[idx - 1])) {
                visited[i] = true;
                dfs(num + i, idx + 1);
                visited[i] = false;
            }
        }
    }

    static boolean check(int a, int b, char c) {
        if (c == '<') {
            if (a > b) return false;
        }
        else if (c == '>') {
            if (a < b) return false;
        }
        return true;
    }
}