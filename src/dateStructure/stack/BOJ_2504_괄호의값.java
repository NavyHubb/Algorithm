package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * [분석]
 * '()'인 괄호열의 값은 2이다
 * '[]'인 괄호열의 값은 3이다
 * '(X)'인 괄호열의 값은 2*값(X)이다
 * '[X]'인 괄호열의 값은 3*값(X)이다
 * XY인 괄호열의 값은 값(X) + 값(Y)이다
 *
 * 주어진 괄호열의 값을 구하라. 만약, 입력이 올바르지 못하면 0을 출력하라
 */
public class BOJ_2504_괄호의값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }

    static int solution(String str) {
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int tmp = 1;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                tmp *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                tmp *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {  // 스택이 비어있거나 현재의 닫는 괄호와 매치되는 여는 괄호가 없는 경우
                    result = 0;
                    break;
                }
                if (str.charAt(i-1) == '(') {
                    result += tmp;
                }

                // 현재 문자가 닫히는 괄호이므로 이에 매치되는 여는 괄호를 스택에서 추출하면서 tmp에서 현재 괄호의 영향력(곱하기 2하는 부분)을 제거해준다
                stack.pop();
                tmp /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }
                if (str.charAt(i-1) == '[') {
                    result += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }

        return stack.isEmpty() ? result : 0;
    }

}