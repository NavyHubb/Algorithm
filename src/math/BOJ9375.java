package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();

                map.put(category, map.getOrDefault(category, 0) + 1);
            }

            int result = 1;
            for (String c : map.keySet()) {
                result *= map.get(c) + 1;
            }
            System.out.println(result - 1);
        }
    }

}