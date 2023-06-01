package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1339 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[] words = new String[N];  // 입력받은 문자들
        int[] alphabets = new int[26];  // 알파벳 갯수만큼의 길이를 가진 배열

        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        for (String word : words) {
            int temp = (int) Math.pow(10, word.length() - 1);  // 자릿수
            for (int i = 0; i < word.length(); i++) {
                alphabets[(int)word.charAt(i) - 65] += temp;
                temp /= 10;
            }
        }

        Arrays.sort(alphabets);  // 오름차순 정렬
        int digit = 9;
        int sum = 0;

        // 큰 수를 가진 알파벳에 9부터 차례로 수를 부여한다
        for (int i = alphabets.length-1; i >= 0; i--) {
            // 정렬했으므로 0이 나왔으면 더 볼것도 없다
            if (alphabets[i] == 0) {
                break;
            }

            sum += alphabets[i]*digit;
            digit--;
        }

        System.out.println(sum);
    }

}