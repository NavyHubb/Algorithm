package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27172_수나누기게임 {

    static final int SIZE = 1_000_000;
    static int N;
    static int[] nums;
    static boolean[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        cards = new boolean[SIZE+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            cards[nums[i]] = true;
        }

        solution();
    }

    static void solution() {
        int[] result = new int[SIZE+1];


        for (int i : nums) {
            for (int j = i*2; j <= SIZE; j+=i) {
                if (cards[j]) {
                    result[i]++;
                    result[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(result[num]).append(' ');
        }

        System.out.println(sb);
    }

}