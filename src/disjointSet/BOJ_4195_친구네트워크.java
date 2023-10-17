package disjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_4195_친구네트워크 {

    static int F;
    static int[] parent;
    static int[] cnt;  // 각 인원에 연결되어 있는 친구의 수(본인 포함)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            F = Integer.parseInt(br.readLine());
            parent = new int[2*F];
            cnt = new int[2*F];
            Arrays.fill(cnt, 1);

            int idx = 0;
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    parent[idx] = idx;
                    map.put(a, idx++);
                }

                if (!map.containsKey(b)) {
                    parent[idx] = idx;
                    map.put(b, idx++);
                }

                union(map.get(a), map.get(b));
                System.out.println(cnt[find(map.get(b))]);
            }

        }
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;
        
        parent[rootY] = rootX;
        cnt[rootX] += cnt[rootY];
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

}