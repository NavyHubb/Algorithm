package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            items[i] = new Item(m, v);
        }
        // 아이템의 무게를 오름차순, 무게가 같으면 가격을 내림차순
        Arrays.sort(items);

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        // 가방의 무게를 오름차순 정렬
        Arrays.sort(bags);

        // 가격을 내림차순 정렬
        PriorityQueue<Item> pq = new PriorityQueue<>(((o1, o2) -> o2.value - o1.value));
        int arrIdx = 0;
        long ans = 0;
        for (int i = 0; i < K; i++) {
            // 현재 가방에 담을 수 있는 무게의 보석을 모두 담는다
            while (arrIdx < N && items[arrIdx].mass <= bags[i]) {
                Item cur = items[arrIdx++];
                pq.add(new Item(cur.mass, cur.value));
            }

            // 가방에 넣을 수 있는 무게의 보석 중, 가장 가격이 높은 보석을 넣는다
            if (!pq.isEmpty()) {
                ans += pq.poll().value;
            }
        }

        System.out.println(ans);
    }

    static class Item implements Comparable<Item> {
        int mass;
        int value;

        public Item(int mass, int value) {
            this.mass = mass;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            if (mass == o.mass) {
                return o.value - value;
            }
            return mass - o.mass;
        }
    }
}