package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for (int i =0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1.length() == e2.length()) {  // 문자열의 길이가 같을 때
                return e1.compareTo(e2);  // 한 글자씩 비교하여 e1보다 e2가 사전 상 뒤의 글자면 음수(아스키 코드 상 차이만큼) 반환
            } else {
                return e1.length() - e2.length();  // e1의 길이보다 e2의 길이가 더 길면 결과값은 음수. 곧, 순서 바뀜 없음
            }
        });

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]).append("\n");
        for (int i = 1; i < n; i++) {
            // 중복되는 문자열은 한번만 출력
            if (!arr[i].equals(arr[i-1])) {
                sb.append(arr[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}