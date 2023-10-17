package slidingWindow;

import java.util.Scanner;

/**
 * [풀이]
 * 문자열에 포함되어 있는 a의 길이를 슬라이딩 윈도우의 길이로 설정하여
 * 윈도우에 포함되어 있는 b의 갯수가 가장 작아지는 경우가 답이다
 */
public class BOJ_1522_문자열교환 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(solution(str));
    }

    static int solution(String str) {
        int len = str.length();  // 전체 문자열의 길이

        int aCnt = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'a') aCnt++;
        }

        int minBCnt = len - aCnt;  // 문자열에 포함된 b의 갯수
        int bCnt = 0;  // 0 인덱스에서 시작하는 윈도우에 포함되어 있는 b의 갯수
        for (int i = 0; i < aCnt; i++) {
            if (str.charAt(i) == 'b') bCnt++;
        }

        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == 'b') bCnt--;
            if (str.charAt((i+aCnt)%len) == 'b') bCnt++;

            minBCnt = Math.min(minBCnt, bCnt);
        }

        return minBCnt;
    }

}
