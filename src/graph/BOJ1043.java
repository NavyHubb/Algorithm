package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1043 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] parent;
    static boolean[] truePeople = new boolean[51];
    static int total = 0;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // parent 배열 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 진실을 아는 사람 정보 받아오기
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            truePeople[Integer.parseInt(st.nextToken())] = true;
        }

        // 파티 정보를 받아오면서
        // 같은 파티에 있는 사람들 union
        List<Integer>[] peoples = new List[M];
        for (int i = 0; i < M; i++) {
            peoples[i] = new ArrayList<>();
            int pre = 0, cur = 0;

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n > 0) {
                pre = Integer.parseInt(st.nextToken());
                peoples[i].add(pre);
            }

            for (int j = 1; j < n; j++) {
                cur = Integer.parseInt(st.nextToken());
                peoples[i].add(cur);
                union(pre, cur);
                pre = cur;
            }
        }

        // 진실을 아는 사람들의 parent는 함께 파티에 참여했으므로 마찬가지로 진실을 안다
        int parent;
        for (int i = 1; i <= N; i++) {
            if (truePeople[i]) {
                truePeople[find(i)] = true;
            }
        }

        // 각 파티를 돌면서, 진실을 아는 사람과 함께 파티하지 않았으면 total++
        for (int i = 0; i < M; i++) {
            if (peoples[i].size() > 0) {
                parent = find(peoples[i].get(0));

                // 파티의 대표자(parent)가 진실을 모른다? -> 그럼 그 파티는 진실을 아는 사람이 없는거지
                if (!truePeople[parent]) {
                    total++;
                }
            }
        }

        System.out.println(total);
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        // 숫자가 작은 쪽으로 parent 번호 매긴다
        if (x != y) {
            if (x > y) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
        }
    }
}