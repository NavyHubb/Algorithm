package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String S = br.readLine()+"\n";
            // 한 줄 읽고 마지막에 개행 문자 추가

            for (int i = 0; i < S.length(); i++) {
                // 공백을 만난 경우
                if (S.charAt(i) == ' ' || S.charAt(i) == '\n') {
                    // 스택이 빌 때까지 반복
                    while (!stack.isEmpty()) {
                        sb.append(stack.peek());  // stack의 가장 위에 있는 값을 선택(추출 아님)하여 sb(출력)에 저장
                        stack.pop();
                    }

                    // stack을 모두 비우고 공백을 만난다면 출력에도 공백 추가
                    if (S.charAt(i) == ' ') {
                        sb.append(' ');
                    }
                }

                // 문자를 만난 경우
                else {
                    stack.push(S.charAt(i));  // stack에 값 추가
                }
            }

            // 한 줄을 마치고 나면 개행 문자 추가
            sb.append('\n');
        }

        System.out.println(sb);
    }
}