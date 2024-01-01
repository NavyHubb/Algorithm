package recursion.divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 수열 S의 부분 수열의 합으로 나올 수 없는 '가장 작은' 자연수를 구하라
 * S를 이루고있는 수는 100,000보다 작거나 같은 자연수이다
 *
 * [문제 풀이]
 * 수열 S의 멱집합을 구하여 각 부분수열의 원소의 합을 set에 삽입한다
 */
public class BOJ_14225_부분수열의합 {

    static int N;
    static int[] nums;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        check = new boolean[100_000*20 + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    private static int solution() {
        dfs(0, 0);

        int answer = 1;
        while (true) {
            if (check[answer]) {
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            check[sum] = true;
            return;
        }

        dfs(depth+1, sum);
        dfs(depth+1, sum+nums[depth]);
    }

}