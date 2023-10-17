package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [조건]
 * 1초 동안 일어나는 일
 *  미세먼지가 인접 사방으로 확산된다
 *  - 확산은 맵의 범위 내에서 공청기가 없는 칸에 대해서만 이루어진다
 *  - 확산되는 양은 map[r][c]/5 이다. (소수점은 버린다)
 *  - map[r][c]에 남은 먼지 양은 map[r][c] - (map[r][c]/5)*(확산된 방향의 갯수)
 *
 *  공청기가 작동한다
 *  - 위쪽 공청기의 바람은 반시계, 아래쪽은 시계 방향으로 순환한다
 *  - 바람이 불면 미세먼지가 바람의 방향대로 모두 한칸씩 이동한다
 *  - 공청기에서 나오는 바람에는 미세먼지가 없고, 공청기로 들어간 미세먼지는 모두 정화된다
 *
 * 6 <= R, C <= 50
 */
public class Main_BJ_17144_미세먼지안녕_김성재 {

    static int R, C, T;
    static int[][] map;
    static int[][] delta;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution());
    }

    static int solution() {
        for (int t = 0; t < T; t++) {
            spread();
            circulate();
        }

        return getSum();
    }

    // 확산시키기
    static void spread() {
        delta = new int[R][C];  // 확산으로 인한 각 위치별 변화량을 저장할 배열

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) continue;

                int cnt = 0;  // 확산된 칸의 갯수
                for (int d = 0; d < 4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    if (ni < 0 || nj < 0 || ni >= R || nj >= C) continue;  // map의 범위를 벗어난 경우
                    if (map[ni][nj] == -1) continue;  // 공기청정기의 위치인 경우

                    cnt++;
                    delta[ni][nj] += map[i][j]/5;  // (i, j)로부터 확산되어 (ni, nj)에 증가되는 먼지의 양
                }
                delta[i][j] -= (map[i][j]/5) * cnt;  // (i, j)에서 인접 cnt개 칸으로 확산시킴으로써 감소되는 먼지의 양
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += delta[i][j];
            }
        }
    }

    // 순환시키기
    static void circulate() {
        int machine = 0;  // 공기청정기의 위치(위쪽 칸 기준)
        for (int i = 0; i < R; i++) {
            if (map[i][0] == -1) {
                machine = i;
                break;
            }
        }

        // 반시계 방향
        // 좌측변
        for (int i = machine-1; i >= 1; i--) {
            map[i][0] = map[i-1][0];
        }
        // 상측변
        for (int j = 0; j <= C-2; j++) {
            map[0][j] = map[0][j+1];
        }
        // 우측변
        for (int i = 0; i <= machine-1; i++) {  // 위쪽
            map[i][C-1] = map[i+1][C-1];
        }
        // 하측변
        for (int j = C-1; j >= 2; j--) {  // 가장 오른쪽 칸부터 인접 왼쪽 칸의 값을 당겨온다
            map[machine][j] = map[machine][j-1];
        }
        map[machine][1] = 0;  // 공기청정기에서 나온 바람은 먼지의 양이 0이다


        // 시계 방향
        // 좌측변
        for (int i = machine+2; i <= R-2; i++) {
            map[i][0] = map[i+1][0];
        }
        // 하측변
        for (int j = 0; j <= C-2; j++) {
            map[R-1][j] = map[R-1][j+1];
        }
        // 우측변
        for (int i = R-1; i >= machine+2; i--) {
            map[i][C-1] = map[i-1][C-1];
        }
        // 상측변
        for (int j = C-1; j >= 2; j--) {  // 가장 오른쪽 칸부터 인접 왼쪽 칸의 값을 당겨온다
            map[machine+1][j] = map[machine+1][j-1];
        }
        map[machine+1][1] = 0;  // 공기청정기에서 나온 바람은 먼지의 양이 0이다
    }

    // 먼지의 양 구하기
    static int getSum() {
        int sum = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) continue;
                sum += map[i][j];
            }
        }
        return sum;
    }

}