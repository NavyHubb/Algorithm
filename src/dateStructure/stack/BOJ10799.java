package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                stack.push('(');
                continue;
            }

            // 닫는 괄호를 만났을 경우
            if (S.charAt(i) == ')') {
                stack.pop();

                // 직전 문자가 여는 괄호였을 경우 - 즉, 레이저
                if (S.charAt(i - 1) == '(') {
                    result += stack.size();
                }
                // 직전 문자가 닫는 괄호였을 경우
                else {
                    // 닫는 괄호가 연속으로 나온 경우
                    // 현재의 닫는 괄호가 가리키는 쇠막대기가 끝난 것을 의미하므로 쇠막대기의 마지막 한 조각을 카운트해준다
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}