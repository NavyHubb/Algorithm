package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    final static int correct = 100;  // 일곱 난쟁이 키의 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;  // 아홉 난쟁이 키의 합

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                // 아홉 명의 키의 합에서 두 명의 키의 합을 뺐을 때 100이 되는 경우
                if (sum - (arr[i] + arr[j]) == correct) {
                    arr[i] = 0;
                    arr[j] = 0;

                    Arrays.sort(arr);

                    for (int k = 2; k < 9; k++) {
                        sb.append(arr[k]).append("\n");
                    }
                    System.out.println(sb);
                    return;
                }
            }
        }
    }
}