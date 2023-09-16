package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [풀이]
 * 모든 칸에 대해 탐색한다(단, 이미 방문한 칸이라면 건너뛴다)
 * 임의의 칸을 시작으로 해당 칸의 방향에 따라 칸 이동을 하며 방문처리를 한다
 * 연속된 칸은 하나의 시퀀스로 카운트한다(첫 칸의 바로 다음 칸이 이미 방문한 칸이라면 카운트를 하지 않는다)
 *
 */
public class BOJ_16724_피리부는사나이 {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] check;
    static int cnt = 0;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        solution();
        System.out.println(cnt);
    }

    static void solution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    track(i, j);
                }
            }
        }
    }

    static void track(int i, int j) {
        visited[i][j] = true;  // 현위치 방문처리

        int[] next = getNext(i, j);  // 다음 위치 계산
        if (next[0] < 0 || next[1] < 0 || next[0] > N-1 || next[1] > M-1) return;  // 범위를 벗어나면 종료

       if (!visited[next[0]][next[1]]) {
           track(next[0], next[1]);
       } else {
           if (!check[next[0]][next[1]]) {
               cnt++;
           }
       }

       check[i][j] = true;
    }

    static int[] getNext(int i, int j) {
        int nextI = i;
        int nextJ = j;
        switch (map[i][j]) {
            case 'U':
                nextI += di[0];
                nextJ += dj[0];
                break;
            case 'D':
                nextI += di[1];
                nextJ += dj[1];
                break;
            case 'L':
                nextI += di[2];
                nextJ += dj[2];
                break;
            case 'R':
                nextI += di[3];
                nextJ += dj[3];
        }

        return new int[]{nextI, nextJ};
    }

}