package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (check() == true) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean check() throws IOException {
        boolean[] check = new boolean[26];  // 알파벳 개수만큼의 길이를 가진 배열
        int prev = 0;  // 이웃한 문자끼리의 비교를 위한 변수
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);

            if (prev != now) {
                if (check[now - 'a'] == false) {  // 배열의 인덱스 0이 'a'의 자리
                    check[now - 'a'] = true;
                    prev = now;
                } else {  // 직전 문자와 다른 문자인데 이미 등장한 적이 있는 문자라면 그룹 단어가 아닌 것
                    return false;
                }
            }

            // 직전 문자와 같은 문자가 연속하여 등장했을 때는 다음 반복으로 넘어감. 고로, else 문은 불필요
        }

        return true;
    }
}
