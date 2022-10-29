package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 인덱스 1을 출석번호 1로 사용하기 위해 길이 31로 설정
        // 사실상 인덱스 0은 사용하지 않는다
        boolean[] arr = new boolean[31];

        // 28명이 제출했으므로 제출한 사람의 출석번호(즉 입력값)에 해당하는 인덱스의 값을 true로 입력
        // true: 제출, false: 미제출
        for (int i = 0; i < 28; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = true;
        }

        // 인덱스 1부터 30을 돌면서 false값을 가진 인덱스의 인덱스 넘버만 출력
        // 1부터 30까지의 순서로 반복하기 때문에 출력은 자연스레 오름차순 정렬된다
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 30; i++) {
            if (!arr[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}