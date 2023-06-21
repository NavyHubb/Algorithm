package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2096 {
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        solution(map, N);
    }

    static void solution(int[][] map, int N) {
        int[] dpMax = new int[3];
        int[] dpMin = new int[3];
        int[] temp = new int[3];
        System.arraycopy(map[0], 0, dpMax, 0, 3);
        System.arraycopy(map[0], 0, dpMin, 0, 3);

        for (int i = 1; i < N; i++) {
            temp[0] = Math.max(dpMax[0], dpMax[1]) + map[i][0];
            temp[1] = Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2])) + map[i][1];
            temp[2] = Math.max(dpMax[1], dpMax[2]) + map[i][2];
            dpMax[0] = temp[0];
            dpMax[1] = temp[1];
            dpMax[2] = temp[2];

            temp[0] = Math.min(dpMin[0], dpMin[1]) + map[i][0];
            temp[1] = Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2])) + map[i][1];
            temp[2] = Math.min(dpMin[1], dpMin[2]) + map[i][2];

            dpMin[0] = temp[0];
            dpMin[1] = temp[1];
            dpMin[2] = temp[2];
        }

        int max = Arrays.stream(dpMax).max().getAsInt();
        int min = Arrays.stream(dpMin).min().getAsInt();

        System.out.println(max+" "+min);
    }
}
