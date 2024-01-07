package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 도로는 마을과 마을 사이에 있으며, 일방 통행이다
 * 당신은 도로를 따라 운동을 하려는데, 운동 후에는 다시 시작점으로 돌아오기 위해 사이클을 찾으려 한다
 * 사이클을 이루는 도로 길이의 합이 최소가 되는 값을 구하라
 *
 * [문제 풀이]
 * 플로이드 워셜을 통해 한 정점에서 다른 한 정점까지의 거리의 최솟값을 구하고
 * 가능한 사이클의 모든 경우의 수를 탐색하며 최솟값을 구한다
 */
public class BOJ_1956_운동 {

    static final int INF = 1_000_000_000;
    static int V, E;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[V+1][V+1];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // 도로는 일방통행이므로 단방향 연결
            dist[a][b] = weight;
        }

        System.out.println(solution());
    }

    private static int solution() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) continue;

                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 사이클을 구성할 수 있는 모든 경우의 수를 탐색하여 최소값을 찾아낸다
        int result = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) continue;

                // i에서 j로 가는 길이 있고, j에서 i로 가는 길이 있다면 사이클이 존재함을 의미
                if (dist[i][j] != INF && dist[j][i] != INF) {
                    result = Math.min(result, dist[i][j] + dist[j][i]);
                }
            }
        }

        return (result == INF) ? -1 : result;
    }

}