package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class BOJ4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        Loop1 : while (true) {
            String s = br.readLine();

            if (s.equals(".")) break;

            Stack<Character> stack = new Stack<>();

            try {
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);

                    if (c == '(' || c == '[') {
                        stack.push(c);
                    }
                    else if (c == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        }
                        else {
                            sb.append("no").append('\n');
                            continue Loop1;
                        }
                    }
                    else if (c == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                        }
                        else {
                            sb.append("no").append('\n');
                            continue Loop1;
                        }
                    }
                }
            } catch (EmptyStackException e) {  // 빈 스택에 pop()를 했을 때 발생하는 예외
                sb.append("no").append('\n');
                continue;
            }


            if (stack.isEmpty()) {
                sb.append("yes");
            }
            else {
                sb.append("no");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}