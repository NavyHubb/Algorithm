package math.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb.append((int) Math.pow(2, N) - 1).append("\n");

        hanoi(N, 1, 2, 3);

        System.out.println(sb);
    }

    /*
    N: 원판의 갯수
    from: 시작점
    mid: 경유지
    to: 종착지
    from, mid, to는 단계에 따라 변한다.
    예를 들어, 1단계에서는 원판의 이동이 A -> B 이므로 from은 A, to는 B, mid는 B이지만
    3단계에서는 원판의 이동이 B -> C 이므로, from은 B, to는 C, mid는 A이다.
     */
    static void hanoi(int N, int from, int mid, int to) {

        // 원판이 한 개일 경우
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;  // 재귀함수의 종착지. 무한반복을 방지한다.
        }

        // 1 단계
        // 원판 이동 A -> B; 제일 큰 원판은 제외
        hanoi(N-1, from, to, mid);

        // 2 단계
        // 원판 이동 A -> C; 제일 큰 원판
        sb.append(from).append(" ").append(to).append("\n");

        // 3 단계
        // 원판 이동 B -> C
        hanoi(N-1, mid, from, to);
    }
}