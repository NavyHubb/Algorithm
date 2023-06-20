package graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
    public static int N;
    public static int[] nums;
    public static int[] arr;
    public static boolean[] visit;
    public static int sum;
    public static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        arr = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(max);
    }

    public static void dfs(int depth) {
        if (depth == N) {
            sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(arr[i] - arr[i + 1]);
            }
            if (sum > max) {
                max = sum;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = nums[i];
                dfs(depth + 1);
                
                visit[i] = false;
            }
        }
    }
}