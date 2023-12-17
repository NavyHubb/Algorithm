package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 이분 그래프란
 * 그래프의 정점의 집합을 둘로 분할하여, 각 집합에 속한 정점끼리는 서로 인접하지 않도록 분할할 수 있을 때를 말한다
 *
 * [문제 풀이]
 * 모든 정점들에 대해 1 또는 -1로 라벨링을 할 때, 인접한 정점들끼리는 서로 다른 라벨을 가지고 있어야 이분 그래프의 조건을 만족한다
 */
public class BOJ_1707_이분그래프 {

    static int V, E;
    static List<List<Integer>> graph;
    static int[] group;  // 각 노드가 속한 그룹 정보를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            group = new int[V+1];

            // 리스트 초기화
            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            boolean result = false;  // 변수 초기화. false로 하든 true로 하든 상관 없음
            for (int i = 1; i <= V; i++) {
                if (group[i] == 0) {
                    result = bfs(i);
                }
                if (!result) break;  // 한번이라도 실패가 나오면 전체 실패
            }

            if (result) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static boolean bfs(int start) {
        Queue<Integer> que = new LinkedList<>();

        que.add(start);
        group[start] = 1;
        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : graph.get(cur)) {
                // 다음 정점이 현재 정점과 같은 라벨을 가지고 있는 경우 실패 처리
                if (group[cur] == group[next]) return false;

                if (group[next] == 0) {  // 다음 정점이 아직 라벨링되지 않은 경우, 현재 정점과 다른 라벨을 지정해준다
                    group[next] = group[cur] * -1;
                    que.add(next);
                }
            }
        }

        return true;
    }

}