package dateStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine()+" ";  // 공백을 만났을 때 그 이전까지 나왔던 문자들을 출력하기 때문에 입력문의 마지막에 공백 추가

        Stack<Character> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            // '<'를 만났을 때
            if (S.charAt(i) == '<') {
                // 스택에 쌓인 게 있으면 모두 pop하며 출력문에 저장
                // 여는 태그 전 이므로 태그 밖. 태그 밖의 문자들은 역순으로 출력
                while (!stack.isEmpty()) {
                    sb.append(stack.peek());
                    stack.pop();
                }

                // 스택에 쌓인 게 없는 경우
                sb.append('<');
                // 닫는 태그가 나타날 때까지 나타나는 문자들을 그 순서대로 출력문에 저장
                while (S.charAt(i) != '>') {
                    i++;  // 새로운 반복이 시작되고 나서 i가 증가하기 때문에 이 반복문이 끝나면 출력문에 닫는 태그까지 포함된다
                    sb.append(S.charAt(i));
                }
            }
            // 태그 바깥인 경우
            else {
                // 공백을 만난 경우
                if (S.charAt(i) == ' ') {
                    // 스택이 빌 때까지 pop하며 출력문에 저장
                    while (!stack.isEmpty()) {
                        sb.append(stack.peek());
                        stack.pop();
                    }

                    // 스택이 비어있는 상태에서 공백을 만났다면 출력문에도 공백 추가
                    if (S.charAt(i) == ' ') {
                        sb.append(' ');
                    }
                }
                // 문자를 만난 경우
                else {
                    stack.push(S.charAt(i));
                }
            }
        }

        System.out.println(sb);
    }
}