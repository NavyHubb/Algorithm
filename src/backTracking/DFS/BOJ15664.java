package backTracking.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ15664 {
    public static int N, M;
    public static Integer[] nums;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int at, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        int num = 0;
        for (int i = at; i < N; i++) {
            if (!visit[i]) {
                if (num == nums[i]) {
                    continue;
                }

                visit[i] = true;
                arr[depth] = nums[i];
                dfs(i + 1, depth + 1);

                visit[i] = false;

                num = nums[i];
            }
        }
    }
}
