package graph;

import java.awt.SystemTray;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 각 테스트 케이스는 3줄로 이뤄져있다
 * 첫번째 줄: 체스판의 한 변의 길이
 * 두번째 줄: 현재 위치
 * 세번째 줄: 목적지
 *
 * [문제 풀이]
 * BFS로 현재 위치로부터 이동할 수 있는 다음 위치들을 Queue에 삽입한다
 * 이때 depth 별 탐색을 하여 목적지에 도달할 수 있는 최소 이동 횟수를 구한다
 */
public class BOJ_7562_나이트의이동 {

    static int N;  // 체스판 한 변의 길이
    static int[] start, end;  // 시작점과 목적지
    static int[][] delta = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1},
        {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            start = new int[2];
            end = new int[2];

            st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());

            sb.append(solution()).append('\n');
        }

        System.out.println(sb);
    }

    public static int solution() {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        que.add(start);
        visited[start[0]][start[1]] = true;

        int depth = 0;
        Loop: while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                int[] cur = que.poll();
                int i = cur[0], j = cur[1];

                if (i == end[0] && j == end[1]) break Loop;

                for (int d = 0; d < delta.length; d++) {
                    int ni = i + delta[d][0];
                    int nj = j + delta[d][1];

                    if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                    if (visited[ni][nj]) continue;

                    visited[ni][nj] = true;
                    que.add(new int[]{ni, nj});
                }
            }
            depth++;
        }

        return depth;
    }

}
