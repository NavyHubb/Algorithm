package math.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][] arr = new int[9][9];
        int max = 0;

        // 행렬의 내의 모든 값이 같은 값일 때(즉, 최댓값이 두 개 이상인 경우) 그 중 한 곳의 위치를 출력해야 하기 때문에
        // x, y의 초기값을 1~9 사이의 값으로 지정해야 한다. 0이면 틀린다.
        int x = 1;  // 행 위치(1 ~ 9 중 하나)
        int y = 1;  // 열 위치(1 ~ 9 중 하나)

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 새로운 최댓값이 나타나면 max를 갱신하고 해당 위치를 기억
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        sb.append(max).append("\n").append(x).append(" ").append(y);

        System.out.println(sb);
    }
}