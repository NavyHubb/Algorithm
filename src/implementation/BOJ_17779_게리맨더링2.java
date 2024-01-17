package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * (x, y), (x+1, y-1), ..., (x+d1, y-d1)
 * (x, y), (x+1, y+1), ..., (x+d2, y+d2)
 * (x+d1, y-d1), (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2)
 * (x+d2, y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
 * 경계선과 경계선의 안에 포함되어있는 곳은 5번 선거구이다.
 *
 * 1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
 * 2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
 * 3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
 * 4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
 *
 * 조건)
 * d1, d2 ≥ 1
 * 1 ≤ x < x+d1+d2 ≤ N
 * 1 ≤ y-d1 < y < y+d2 ≤ N
 *
 * [문제 풀이]
 * x, y, d1, d2에 대해 모든 경우의 수를 탐색하여
 * 최솟값을 찾는다
 */
public class BOJ_17779_게리맨더링2 {

    static int N, total;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        System.out.println(solution());
    }
    
    private static int solution() {
        int min = Integer.MAX_VALUE;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (x + d1 + d2 >= N) continue;
                        if (y - d1 < 0 || y + d2 >= N) continue;

                        min = Math.min(min, simulation(x, y, d1, d2));
                    }
                }
            }
        }

        return min;
    }

    private static int simulation(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[N][N];

        // 경계선 마킹
        for (int i = 0; i <= d1; i++) {
            border[x+i][y-i] = true;
            border[x+d2+i][y+d2-i] = true;
        }
        for (int i = 0; i <= d2; i++) {
            border[x+i][y+i] = true;
            border[x+d1+i][y-d1+i] = true;
        }
        
        int[] people = new int[5];  // 구역별 인구수

        // 1 선거구
        for (int r = 0; r < x+d1; r++) {
            for (int c = 0; c <= y; c++) {
                if (border[r][c]) break;
                people[0] += map[r][c];
            }
        }

        // 2 선거구
        for (int r = 0; r <= x+d2; r++) {
            for (int c = N-1; c > y; c--) {
                if (border[r][c]) break;
                people[1] += map[r][c];
            }
        }

        // 3 선거구
        for (int r = x+d1; r < N; r++) {
            for (int c = 0; c < y-d1+d2; c++) {
                if (border[r][c]) break;
                people[2] += map[r][c];
            }
        }

        // 4 선거구
        for (int r = x+d2+1; r < N; r++) {
            for (int c = N-1; c >= y-d1+d2; c--) {
                if (border[r][c]) break;
                people[3] += map[r][c];
            }
        }

        // 5 선거구
        people[4] = total;
        for (int i = 0; i <= 3; i++) {
            people[4] -= people[i];
        }

        Arrays.sort(people);

        return people[4] - people[0];
    }

}
