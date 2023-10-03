package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [조건]
 * 예은이는 임의의 노드에 떨어진다
 * 떨어진 노드에서 주어진 수색 범위 내(현재 위치 포함)의 아이템을 모두 얻게 된다
 * 이때 얻을 수 있는 아이템 갯수의 최댓값을 구하라
 *
 * [풀이]
 * 플로이드워셜을 통해 모든 노드에 대한 모든 노드로의 거리를 구하고
 * 각 노드별로 얻을 수 있는 아이템 수를 구하여 그 중 최댓값을 구한다
 */
public class BOJ_14938_서강그라운드 {

    static int V, E, R;
    static int[] items;
    static int[][] dist;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());  // 정점의 갯수
        R = Integer.parseInt(st.nextToken());  // 범위의 크기
        E = Integer.parseInt(st.nextToken());  // 간선의 갯수

        st = new StringTokenizer(br.readLine());
        items = new int[V+1];
        for (int i = 1; i <= V; i++) {
            items[i] = Integer.parseInt(st.nextToken());  // 노드 별 아이템의 갯수
        }

        // 거리 배열 초기화
        dist = new int[V+1][V+1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            dist[from][to] = weight;
            dist[to][from] = weight;
        }

        System.out.println(solution());
    }

    static int solution() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int[] result = new int[V+1];  // 노드 별 획득할 수 있는 아이템 갯수
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (dist[i][j] <= R) {  // 수색 범위 내에 있는 아이템 갯수 카운트
                    result[i] += items[j];
                }
            }
        }

        return Arrays.stream(result).max().getAsInt();
    }

}
