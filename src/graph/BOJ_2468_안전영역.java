package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [조건]
 * 내리는 비의 양에 따른 모든 경우를 고려했을 때,
 * 물에 잠기지 않는 안전영역의 최대 개수를 구하라
 *
 * [풀이]
 * 높이의 최댓값부터 비가 내리는 양으로 상정하여 역순으로 탐색한다
 * 비가 내리는 양이 적어질수록 잠기지 않는 구역이 늘어나므로 안전영역의 개수가 적어질 것이다
 */
public class BOJ_2468_안전영역 {

    static int N, maxHeight;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        maxHeight = 0;  // 높이의 최댓값
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        System.out.println(solution());
    }

    static int solution() {
        int maxCnt = 1;  // 비가 오지 않았을 경우에는 안전영역이 한 개이다

        for (int h = 1; h < maxHeight; h++) {  // 강수량
            int cnt = 0;  // 안전영역 갯수
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] <= h) continue;  // 잠긴 위치
                    if (visited[i][j]) continue;  // 이미 방문한 위치

                    BFS(i, j, h);
                    cnt++;
                }
            }

            maxCnt = Math.max(maxCnt, cnt);
//            if (cnt >= maxCnt) {
//                maxCnt = cnt;
//            } else {
//                break;
//            }
        }

        return maxCnt;
    }

    static void BFS(int startI, int startJ, int height) {
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, -1, 1};

        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{startI, startJ});
        visited[startI][startJ] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int i = cur[0], j = cur[1];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                if (map[ni][nj] <= height) continue;
                if (visited[ni][nj]) continue;

                visited[ni][nj] = true;
                que.add(new int[]{ni, nj});
            }
        }
    }

}
