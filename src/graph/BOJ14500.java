package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14500 {
    static int N;
    static int M;
    static int[][] data;
    static boolean[][] visit;
    static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N][];
        for (int i = 0; i < N; i++) {
            data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        visit = new boolean[N][M];
        // 전체 탐색(dfs)
        // 연쇄된 dfs가 끝나면 해당 인덱스를 다시 미방문 처리하여 다음 반복에 영향이 없도록
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visit[i][j] = true;
                solution(i, j, data[i][j], 1);
                visit[i][j] = false;
            }
        }

        System.out.println(max);
    }

    static void solution(int row, int col, int sum, int count) {
        // 테트로미노 완성 시 수들의 합 계산하여 최댓값 갱신
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        // 상하좌우 탐색
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int k = 0; k < dx.length; k++) {
            int newI = row + dx[k];
            int newJ = col + dy[k];

            if (newI < 0 || newI >= N || newJ < 0 || newJ >= M) {
                continue;
            }

            if (!visit[newI][newJ]) {
                // 'ㅗ' 모양 테트로미노를 만들기 위해 두번째 칸에서 탐색 진행
                if (count == 2) {
                    visit[newI][newJ] = true;
                    solution(row, col, sum + data[newI][newJ], count + 1);
                    visit[newI][newJ] = false;
                }

                visit[newI][newJ] = true;
                solution(newI, newJ, sum + data[newI][newJ], count + 1);
                visit[newI][newJ] = false;
            }
        }

    }
}