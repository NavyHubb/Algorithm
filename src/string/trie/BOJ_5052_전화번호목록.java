package string.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_5052_전화번호목록 {

    static int N;
    static String[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            nums = new String[N];

            for (int i = 0; i < N; i++) {
                String n = br.readLine();
                nums[i] = n;
            }

            if (solution()) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean solution() {
        // String을 오름차순 정렬하면
        // 접두어 관계에 있는 두 문자열은 인접하게 정렬된다
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i].startsWith(nums[i-1])) {
                return false;
            }
        }
        return true;
    }

}

