package graph.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 0번 노드부터 N-1번 노드까지, 각 노드의 부모가 주어진다
 * 노드를 지우면 그 노드와 노드의 모든 자손이 트리에서 제거된다.
 * 입력으로 주어진 노드를 지웠을 때, 리프 노드의 개수를 구하라
 *
 * [문제 풀이]
 *
 */
public class BOJ_1068_트리 {

    static int N, cnt, target;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cnt = 0;
        parent = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());  // 루트 입력
        int root = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            parent[i] = n;

            if (parent[i] == -1) root = i;
        }

        target = Integer.parseInt(br.readLine());
        remove(target);

        dfs(root);
        System.out.println(cnt);
    }

    private static void remove(int n) {
        parent[n] = -2;  // 삭제된 노드 -2로 표시

        // 삭제된 노드의 자식들도 삭제
        for (int i = 0; i < N; i++) {
            if (parent[i] == n) {
                remove(i);
            }
        }
    }

    private static void dfs(int cur) {
        boolean isLeaf = true;

        visited[cur] = true;
        if (parent[cur] != -2) {
            for (int i = 0; i < N; i++) {
                if (parent[i] == cur && !visited[i]) {
                    dfs(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) cnt++;
        }
    }

}