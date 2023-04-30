package dateStructure.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (setA.contains(Integer.parseInt(st.nextToken()))) {
                count++;
            }
        }

        System.out.println(N + M - count * 2);
    }
}