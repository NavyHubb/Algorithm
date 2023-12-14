package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 경사로를 놓아서 만들 수 있는 지나갈 수 있는 길의 갯수를 구하라
 * 놓을 수 있는 경사로의 길이는 주어진다
 * 경사로를 놓을 수 있는 조건
 * - 낮은 칸과 높은 칸의 높이 차이는 1이어야 한다
 *
 * [문제 풀이]
 * 각 행과 열을 탐색하며 경사로를 놓을 수 있는지 체크한다
 */
public class BOJ_14890_경사로 {

    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution());
    }

    public static int solution() {
        int cnt = 0;  // 지나갈 수 있는 길의 개수

        for (int i = 0; i < N; i++) {
            if (check(i, true)) cnt++;
            if (check(i, false)) cnt++;
        }

        return cnt;
    }

    public static boolean check(int idx, boolean isRow) {
        boolean[] installed = new boolean[N];  // 경사로 설치 여부

        if (isRow) {  // 행 탐색
            for (int i = 1; i < N; i++) {  // 첫번째 칸에 오르막 경사로를 놓을 경우의 수를 고려하여 0이 아닌 1부터 시작
                if (map[idx][i] == map[idx][i-1]) {
                    continue;  // 높이가 같을 경우 건너뛴다
                } else if (map[idx][i] - map[idx][i-1] == 1) {  // 오름차순으로 높이 차가 1인 경우
                    // 현재 칸부터 그 이전의 칸들에 경사로를 놓을 수 있는지 확인
                    for (int j = i-1; j >= i-L; j--) {
                        if (j < 0 || map[idx][j] != map[idx][i]-1 || installed[j]) {  // 범위를 벗어나거나, 높이가 다르거나, 경사로가 이미 설치된 곳인 경우
                            return false;
                        }
                        installed[j] = true;
                    }
                } else if (map[idx][i] - map[idx][i-1] == -1) {  // 내림차순으로 높이 차가 1인 경우
                    // 현재 칸부터 그 이후의 칸들에 경사로를 놓을 수 있는지 확인
                    for (int j = i; j < i+L; j++) {  // i 번째 칸부터 카운트가 들어가므로 i+L 번째 칸은 제외된다
                        if (j >= N || map[idx][j] != map[idx][i] || installed[j]) {  // 범위를 벗어나거나, 높이가 다르거나, 경사로가 이미 설치된 곳인 경우
                            return false;
                        }
                        installed[j] = true;
                    }
                } else {  // 높이 차가 1 초과인 경우
                    return false;
                }
            }

            return true;
        } else {  // 열 탐색
            for (int i = 1; i < N; i++) {  // 첫번째 칸에 오르막 경사로를 놓을 경우의 수를 고려하여 0이 아닌 1부터 시작
                if (map[i][idx] == map[i-1][idx]) {
                    continue;  // 높이가 같을 경우 건너뛴다
                } else if (map[i][idx] - map[i-1][idx] == 1) {  // 오름차순으로 높이 차가 1인 경우
                    // 현재 칸부터 그 이전의 칸들에 경사로를 놓을 수 있는지 확인
                    for (int j = i-1; j >= i-L; j--) {
                        if (j < 0 || map[j][idx] != map[i][idx]-1 || installed[j]) {  // 범위를 벗어나거나, 높이가 다르거나, 경사로가 이미 설치된 곳인 경우
                            return false;
                        }
                        installed[j] = true;
                    }
                } else if (map[i][idx] - map[i-1][idx] == -1) {  // 내림차순으로 높이 차가 1인 경우
                    // 현재 칸부터 그 이후의 칸들에 경사로를 놓을 수 있는지 확인
                    for (int j = i; j < i+L; j++) {  // i 번째 칸부터 카운트가 들어가므로 i+L 번째 칸은 제외된다
                        if (j >= N || map[j][idx] != map[i][idx] || installed[j]) {  // 범위를 벗어나거나, 높이가 다르거나, 경사로가 이미 설치된 곳인 경우
                            return false;
                        }
                        installed[j] = true;
                    }
                } else {  // 높이 차가 1 초과인 경우
                    return false;
                }
            }

            return true;
        }
    }

}