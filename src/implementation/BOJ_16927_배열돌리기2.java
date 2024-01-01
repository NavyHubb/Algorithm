package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 배열을 depth 별로 주어진 횟수만큼 '반시계방향'으로 회전 시킨 결과를 출력하라
 * 배열돌리기1과 달리 회전수 R의 최댓값이 10^9 로 매우 큰 편이다
 *
 * [문제 풀이]
 * 배열을 층(depth)별로 회전시킨다
 * 가장 바깥쪽 층이 0층이며, 그 층의 안쪽 층이 1층이라 칭한다
 *
 * 이 문제의 경우 R 값의 범위가 int 범위의 한계에 근접할 정도로 크므로
 * 각 층별로 한 바퀴를 돌아 원상태로 돌아오는 사이클을 고려하여 R 값을 조정하는 것이 관건이다
 *
 * 한 칸 회전시키는 알고리즘보다 R 값을 조정하는 로직을 구현하는 것이 문제 통과에 직접적인 영향을 끼친다
 */
public class BOJ_16927_배열돌리기2 {

    static int N, M, R;
    static int[][] map;
    static int[] di = {0, 1, 0, -1};
    static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void solution() {
        int depth = Math.min(N, M) / 2;  // 층의 갯수

        for (int d = 0; d < depth; d++) {
            int rLen = R % ((N-2*d)*2 + (M-2*d)*2 - 4);
            rotate(d, rLen);
        }
    }

    private static void rotate(int depth, int rLen) {

        int i = depth;  // 회전을 시작할 위치의 행 인덱스
        int j = depth;  // 회전을 시작할 위치의 열 인덱스


        // 주어진 회전수(rLen)만큼 반복
        for (int r = 0; r < rLen; r++) {
            int tmp = map[depth][depth];  // 현재 층의 좌측 상단 모서리의 값 저장
            int d = 0;  // 방향 인덱스

            while (d < 4) {  // 네 방향을 모두 탐색할 때까지 반복
                int ni = i + di[d];
                int nj = j + dj[d];

                if (isOutOfRange(ni, nj, depth)) {
                    d++;
                } else {
                    map[i][j] = map[ni][nj];
                    i = ni;
                    j = nj;
                }
            }
            // 저장해 두었던 처음 위치의 값 대입
            map[depth+1][depth] = tmp;
        }


    }

    private static boolean isOutOfRange(int i, int j, int depth) {
        return i < depth || j < depth || i >= N-depth || j >= M-depth;
    }

}