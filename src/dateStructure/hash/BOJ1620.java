package dateStructure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] nameArr = new String[N + 1];

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(name, i);
            nameArr[i] = name;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            if (isNumber(s)) {
                int idx = Integer.parseInt(s);
                sb.append(nameArr[idx]);
            }
            else {
                sb.append(map.get(s));
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}