package graph.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {

    public static int N;
    public static int M;
    public static int[] arr;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visit = new boolean[N];  // 각 노드의 방문 여부 확인을 위한 배열

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        // 출력해야할 갯수만큼의 깊이에 도달하면 지금까지 탐색한 값들을 출력값에 저장
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            // 방문하지 않은 노드인 경우
            if (!visit[i]) {
                visit[i] = true;  // 이미 arr에 담긴 값에 대해서는 중복해서 또 담지 않기 위한 조치
                arr[depth] = i + 1;
                dfs(depth + 1);  // 자식 노드 방문을 위해 depth 증가

                visit[i] = false;
            }
        }
    }
}