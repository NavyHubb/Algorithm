package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 사이클의 정의:
 * 서로 다른 위치의 네 개 이상의 점이 모두 서로 같은 색인 경우
 * 사이클이 존재하면 "Yes", 존재하지 않으면 "No"를 출력하라
 *
 * [문제 풀이]
 * DFS로 인접 사방에 같은 색상의 점이 있는지 확인하며 탐색한다
 * 탐색 중 이미 방문처리된 점을 만난다면 사이클이 존재함을 의미
 * 단, depth가 4 이상이어야 한다
 */
public class BOJ_16929_TwoDots {

    static int N, M, startI, startJ;
    static char[][] map;
    static boolean[][] visited;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0 ,-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        solution();
    }

    private static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                startI = i;
                startJ = j;
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println("No");
    }

    private static void dfs(int i, int j, char color, int depth) {
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];

            if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;  // 범위를 벗어나는 경우
            if (map[ni][nj] != color) continue;  // 색상이 다른 경우

            if (visited[ni][nj]) {  // 이미 방문한 곳인 경우
                if (startI == ni && startJ == nj && depth >= 3) {  // 탐색의 시작점이면서 현재 depth가 3 이상인 경우
                    System.out.println("Yes");
                    System.exit(0);
                }
            } else {
                visited[ni][nj] = true;
                dfs(ni, nj, color, depth+1);
                visited[ni][nj] = false;
            }

        }
    }

}
