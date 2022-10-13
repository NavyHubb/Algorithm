package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3003 {
    public static void main(String[] args) throws IOException {
        int[] arrPreset = {1, 1, 2, 2, 2, 8};
        int[] arrInput = new int[6];
        int[] arrAnswer = new int[6];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            arrInput[i] = Integer.parseInt(st.nextToken());
            arrAnswer[i] = arrPreset[i] - arrInput[i];
            sb.append(arrAnswer[i]).append(" ");
        }

        System.out.println(sb);
    }
}
