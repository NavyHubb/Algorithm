package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3085 {
    static char[][] board;
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        // 사탕 입력 받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 가로로 인접한 두 사탕 교환하여 최댓값 갱신하고 원위치
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 가로로 인접한 사탕 맞교환
                char temp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = temp;

                // 가로, 세로 체크하여 최댓값 갱신
                arrCheck();

                // 교환했던 사탕 원위치
                temp = board[i][j];
                board[i][j] = board[i][j + 1];
                board[i][j + 1] = temp;
            }
        }

        // 세로로 인접한 두 사탕 교환하여 최댓값 갱신하고 원위치
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 세로로 인접한 사탕 맞교환
                char temp = board[j][i];
                board[j][i] = board[j + 1][i];
                board[j + 1][i] = temp;

                // 가로, 세로 체크하여 최댓값 갱신
                arrCheck();

                // 교환했던 사탕 원위치
                temp = board[j][i];
                board[j][i] = board[j + 1][i];
                board[j + 1][i] = temp;
            }
        }

        System.out.println(max);
    }

    // 가로, 세로 모두 비교해보면서 주어진 배열에서 먹을 수 있는 사탕의 최대 갯수 탐색
    public static void arrCheck() {

        // 가로로 체크
        for (int i = 0; i < N; i++) {
            int count = 1;  // 먹을 수 있는 사탕 개수
            for (int j = 0; j < N - 1; j++) {

                // 자기 오른쪽의 있는 사탕과 비교했을 때 색깔이 같으면 먹을 수 있는 사탕 갯수 카운트
                if (board[i][j] == board[i][j+1]) {
                    count++;
                }
                // 색이 다르면 다시 1부터 카운트 해야 하므로 1로 초기화
                else {
                    count = 1;
                }

                // 최댓값 갱신
                max = Math.max(max, count);
            }
        }

        // 세로로 체크
        for (int i = 0; i < N; i++) {
            int count = 1;  // 먹을 수 있는 사탕 개수
            for (int j = 0; j < N - 1; j++) {

                /**
                 * 세로로 비교의 경우
                 * 열 인덱스가 고정되어 있는 상태에서 행 인덱스를 바꾸어가며 탐색해야 하기 때문에
                 * 가로 비교와 달리 board[j][i]와 같이 행과 열의 변수를 서로 바꾸어 준다
                 */
                if (board[j][i] == board[j + 1][i]) {
                    count++;
                }
                else {
                    count = 1;
                }

                max = Math.max(max, count);
            }
        }
    }
}