package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [문제 분석]
 * 인원을 반으로 나누었을 때
 * 두 팀간의 능력치 차이의 최솟값을 구하라
 *
 * [문제 풀이]
 * 팀을 구성하는 모든 조합을 구하고 각 조합에서의 능력치 차이를 갱신하며 최솟값을 구한다
 */
public class BOJ_14889_스타트와링크 {

    static int N;
    static int[][] map;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }
        visited = new boolean[N];

        dfs(0, 0);
        System.out.println(minDiff);
    }

    private static void dfs(int depth, int start) {
        if (depth == N/2) {
            getDiff();
            return;
        }

        for (int i = start; i < N; i++) {
            visited[i] = true;
            dfs(depth+1, i+1);
            visited[i] = false;
        }
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

        minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
    }

}
