package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14500 {

    static int max = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] visit;
    static int n;
    static int m;

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};  // 1차원 변동값
    static int[] dy = {0, 0, -1, 1};  // 2차원 변동값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visit = new boolean[n][m];

        Queue<Integer> q = new LinkedList<>();

        // 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                solve(i, j, arr[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void solve(int row, int col, int sum, int count) {
        // 테트로미노 완성 시 수들의 합 계산
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int curRow = row + dx[i];
            int curCol = col + dy[i];

            // 주어진 직사각형 범위를 벗어나는 경우
            if (curRow < 0 || curRow >= n || curCol < 0 || curCol >= m) {
                continue;
            }

            // 아직 탐색하지 않은 곳인 경우
            if (!visit[curRow][curCol]) {
                if (count == 2) {
                    visit[curRow][curCol] = true;
                    solve(row, col, sum + arr[curRow][curCol], count + 1);
                    visit[curRow][curCol] = false;
                }

                visit[curRow][curCol] = true;
                solve(curRow, curCol, sum + arr[curRow][curCol], count + 1);
                visit[curRow][curCol] = false;
            }
        }


    }
}
