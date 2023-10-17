package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * [조건]
 * 문자열에 폭발문자열이 들어있으면 그 문자열은 기존 문자열에서 사라진다
 * 사라지고 남은 문자열은 합쳐진다
 * 합쳐진 문자열에 폭발문자열이 포함되어 있으면 폭발이 또 이루어진다
 * 폭발은 폭발문자열이 없을 때까지 진행된다
 * 더이상 폭발이 일어나지 않을 때 남아있는 문자열을 구하라
 * 남은 문자열이 없을 경우 "FRULA"를 반환한다
 */
public class BOJ_9935_문자열폭발 {

    static String str, bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        bomb = br.readLine();

        System.out.println(solution());
    }

    static String solution() {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= bomb.length()) {  // 스택에 폭발문자열의 길이만큼의 문자가 쌓이면 폭발문자열 탐색 시작
                boolean isContained = true;  // 대상 문자열에 폭발 문자열이 포함되었는지 여부

                for (int j = 0; j < bomb.length(); j++) {
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isContained = false;
                        break;
                    }
                }

                if (isContained) {  // 폭발 문자열이 포함된 경우
                    for (int j = 0; j < bomb.length(); j++) {  // 스택에서 폭발 문자열의 길이만큼 원소 추출
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return "FRULA";
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }

            return sb.toString();
        }
    }
}
