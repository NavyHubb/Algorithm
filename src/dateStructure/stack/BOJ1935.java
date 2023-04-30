package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String ex = br.readLine();  // 후위 표기식

        int[] arr = new int[n];  // 피연산자 배열
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> operand = new Stack<>();  // 결과값이 실수형이기 때문에 Double형으로 선언

        for (int i = 0; i < ex.length(); i++) {
            char ch = ex.charAt(i);

            // operand
            if ('A' <= ch && ch <= 'Z') {
                // 알파벳은 피연산자를 가리키기 때문에 해당하는 값을 그대로 스택에 푸시해준다
                double d = arr[ch - 'A'];
                operand.push(d);
            }
            // operator
            else {
                // 알파벳이 아니라면 연산자인 경우
                // 피연산자를 스택에서 팝해서 나타난 연산자에 해당하는 연산을 해준뒤 결과값을 다시 스택에 푸시
                double d1 = operand.pop();
                double d2 = operand.pop();
                double d3 = 0.0;

                switch (ch) {
                    case '+':
                        d3 = d2 + d1;
                        break;
                    case '-':
                        d3 = d2 - d1;
                        break;
                    case '*':
                        d3 = d2 * d1;
                        break;
                    case '/':
                        d3 = d2 / d1;
                        break;
                }

                operand.push(d3);
            }
        }

        System.out.printf("%.2f", operand.pop());

    }
}