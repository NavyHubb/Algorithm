package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 가장 처음에 주사위의 모든 면에는 0이 적혀져 있다
 * 지도의 각 칸에는 정수가 하나씩 적혀져 있다
 *
 * 지도 위에 주사위를 굴렸을 때,
 * 주사위가 던져진 위치의 칸에 0이 적혀져 있으면, '주사위 바닥 -> 칸'으로 수가 복사되고
 * 0이 아니면, '칸 -> 주사위 바닥'으로 수가 복사되고, 바닥은 0이 된다
 *
 * 이동명령은
 * 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
 *
 * 주사위가 이동했을 때마다 상단에 쓰여 있는 값을 구하라
 * 명령에 의해 지도 밖으로 벗어나는 경우 해당 명령은 무시하여 출력하지 않는다
 *
 * [문제 풀이]
 * 주사위의 각 방향에 어떤 수가 적혀있는지 저장하는 배열 dice[]를 만든다
 * 주사위를 굴리는 방향에 따라 dice[] 배열의 요소가 어떻게 바뀌는지를 정의한다
 */
public class BOJ_14499_주사위굴리기 {

    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[7];
    static int[] di = {0, 0, 0, -1, 1};
    static int[] dj = {0, 1, -1, 0, 0};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            move(dir);
        }

        System.out.println(sb);
    }

    private static void move(int dir) {
        int nx = x + di[dir];
        int ny = y + dj[dir];

        if (nx < 0 || ny < 0 || nx >= N || ny >= M) return;  // 범위를 벗어난 경우

        // 위치 이동
        x = nx;
        y = ny;

        // 주사위 굴리기
        roll(dir);

        if (map[x][y] == 0) {  // 이동한 칸이 0인 경우
            map[x][y] = dice[6];
        } else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }
        sb.append(dice[1]).append('\n');
    }

    private static void roll(int dir) {
        int tmp = dice[1];

        switch (dir) {
            case 1:  // 동쪽
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = tmp;
                break;
            case 2: // 서쪽
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = tmp;
                break;
            case 3: // 북쪽
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = tmp;
                break;
            case 4: // 남쪽
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = tmp;
        }
    }

}