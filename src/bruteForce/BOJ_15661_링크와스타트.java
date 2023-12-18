package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [문제 분석]
 * 전체 인원을 두 팀으로 나누었을 때, 두 팀간의 능력치 합의 차이가 최소가 되는 값을 구하라
 * 두 팀의 인원은 서로 같지 않아도 되지만, 한 팀에 한 명 이상이 있어야 한다
 *
 * [문제 풀이]
 * 재귀를 이용하여 팀을 구성하는 모든 부분집합, 즉 멱집합을 구하여 능력치합의 최솟값을 구한다
 */
public class BOJ_15661_링크와스타트 {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[N];

        dfs(0);
        System.out.println(minDiff);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            getDiff();
            return;
        }

        visited[depth] = false;
        dfs(depth+1);

        visited[depth] = true;
        dfs(depth+1);
    }

    private static void getDiff() {
        int sumA = 0;
        int sumB = 0;

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    sumA += map[i][j] + map[j][i];
                } else if (!visited[i] && !visited[j]) {
                    sumB += map[i][j] + map[j][i];
                }
            }
        }

        if (minDiff == 0) {
            System.out.println(0);
            System.exit(0);
        }

        minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
    }

}
