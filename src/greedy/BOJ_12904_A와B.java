package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 두 가지 연산
 * - 문자열의 뒤에 A를 추가한다
 * - 문자열을 뒤집고 뒤에 B를 추가한다
 */
public class BOJ_12904_A와B {

    static StringBuffer S, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = new StringBuffer(br.readLine());
        T = new StringBuffer(br.readLine());

        System.out.println(solution());
    }

    static int solution() {
        while (S.length() < T.length()) {
            if (T.charAt(T.length()-1) == 'A') {
                T.deleteCharAt(T.length()-1);
            } else if (T.charAt(T.length()-1) == 'B') {
                T.deleteCharAt(T.length()-1);
                T.reverse();
            }
        }

        if (S.toString().equals(T.toString())) {  // StringBuffer는 equals() 메서드를 override하지 않기 때문에 == 비교를 한 것과 같은 결과를 반환한다.
            return 1;
        }
        return 0;
    }

}