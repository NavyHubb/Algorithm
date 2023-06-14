package backTracking.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9663 {
    static int N;
    static int[] board;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N];
        cnt = 0;
        nQueen(0);

        System.out.println(cnt);
    }

    static void nQueen(int row) {
        // 가능한 경우 찾았을 때
        if (row == N) {
            cnt++;
            return;
        }

        // 첫 행의 1~N 번째에 놓는 경우의 수를 모두 탐색
        for (int i = 0; i < N; i++) {
            board[row] = i;

            if (isPromising(row)) {
                nQueen(row+1);
            }
        }
    }

    static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            if (board[i] == board[row] || row - i == Math.abs(board[i] - board[row])) {
                return false;
            }
        }
        return true;
    }

}