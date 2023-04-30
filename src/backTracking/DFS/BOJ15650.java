package backTracking.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15650 {
    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        // at은 실질적으로 저장되는 값이므로 1부터이고
        // depth는 인덱스 값(0이 1에 대응)이므로 0부터 시작한다
        dfs(1, 0);

        System.out.println(sb);
    }

    /**
     * @param at : 반복문의 시작 위치
     * @param depth
     */
    public static void dfs(int at, int depth) {
        // 깊이가 M에 도달했을 경우 출력
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            // 현재 깊이를 인덱스로 하여 해당 위치에 i값 저장
            arr[depth] = i;

            // 현재 i값보다 다음 재귀에서 더 커야하므로 i + 1 값을 넘겨주고, 깊이또한 1 증가시켜 재귀호출
            dfs(i + 1, depth + 1);
        }
    }
}
