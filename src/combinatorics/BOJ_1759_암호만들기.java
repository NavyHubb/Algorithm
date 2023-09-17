package combinatorics;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Scanner;

/**
 * 암호는 최소 1개의 모음, 2개의 자음으로 이루어져있다
 * 암호는 알파벳 순서대로 나열되어야 한다
 */
public class BOJ_1759_암호만들기 {

    static int L, C;
    static String[] chars;
    static String[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        chars = new String[C];
        for (int i = 0; i < C; i++) {
            chars[i] = sc.next();
        }
        output = new String[L];

        solution();
        System.out.println(sb);
    }

    static void solution() {
        Arrays.sort(chars);
        comb(0, 0);
    }

    static void comb(int depth, int start) {
        if (depth == L) {
            if (check()) {
                for (int i = 0; i < output.length; i++) {
                    sb.append(output[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < chars.length; i++) {
            output[depth] = chars[i];
            comb(depth+1, i+1);
        }
    }

    // 최소 모음, 자음 갯수를 충족하면 true 반환
    static boolean check() {
        int cCnt = 0;  // 자음 갯수
        int vCnt = 0;  // 모음 갯수

        String vowel = "aeiou";
        for (int i = 0; i < output.length; i++) {
            if (vowel.contains(output[i])) {
                vCnt++;
            } else {
                cCnt++;
            }
        }

        if (cCnt >= 2 && vCnt >= 1) {
            return true;
        }
        return false;
    }

}
