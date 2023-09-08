package implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * [조건]
 * 플라스틱 숫자 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다
 * 방 번호가 주어졌을 때, 필요한 세트의 갯수의 최솟값을 출력하라
 * 6과 9는 서로 뒤집어서 이용할 수 있다
 *
 * [풀이]
 * 0 ~ 9 의 수를 자릿수로 가지는 갯수를 저장하는 배열을 생성한다
 * 자릿수가 6이거나 9일 때 6의 갯수와 9의 갯수 중 그 값이 작은 쪽으로 카운트를 올려준다
 */
public class BOJ_1475_방번호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(solution(N));
    }

    static int solution(int N) {
        int[] cnts = new int[10];

        while (N > 0) {
            int n = N % 10;

            if (n == 6 || n == 9) {
                if (cnts[6] > cnts[9]) {
                    cnts[9]++;
                } else {
                    cnts[6]++;
                }
            } else {
                cnts[n]++;
            }

            N /= 10;
        }

        return Arrays.stream(cnts).max().getAsInt();
    }

}