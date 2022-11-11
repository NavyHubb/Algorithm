package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String S = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();  // 커서 좌측의 문자들; 문자 순서대로 입력
        Stack<Character> right = new Stack<>();  // 커서 우측의 문자들; 문자 역순으로 입력

        // 초기 입력값은 모두 커서 좌측에 생성되므로 left에 stacking
        for (int i = 0; i < S.length(); i++) {
            left.push(S.charAt(i));
        }

        while (M-- > 0) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch (c) {
                // 커서 우측의 top을 좌측의 top으로 옮기기
                case 'L':
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                // 커서 좌측의 top을 우측의 top으로 옮기기
                case 'D':
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                // 커서 좌측의 top 삭제
                case 'B':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                // 커서 좌측에 push
                case 'P':
                    left.push(command.charAt(2));
                default: break;
            }
        }

        // 커서 좌측의 문자들을 우측으로 모두 이동시킨 다음 우측 stack을 차례대로 pop
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }
}