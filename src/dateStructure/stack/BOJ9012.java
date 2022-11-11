package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            sb.append(solution(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }

    static String solution(String S) {
        // 스택 초기화
        stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            // 여는 괄호일 경우
            if (c == '(') {
                stack.push(c);
            }
            // 닫는 괄호일 경우
            else {
                // 열린 게 없는데 닫으려 한다면 올바르지 않은 것
                if (stack.isEmpty()) {
                    return "NO";
                }
                // 열린 괄호 하나 추출해주기
                else {
                    stack.pop();
                }
            }
        }

        // 문자열을 탐색을 마쳤을 때 스택이 비어있다면 올바른 것
        if (stack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
