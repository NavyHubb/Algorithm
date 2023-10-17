package greedy;

import java.util.Scanner;

/**
 * [풀이]
 * i번째 비행기를 1~i 게이트에 도킹할 수 있을 때
 * 기본적으로 i 게이트를 최우선적으로 고려하고 그다음으로 i-1, i-2, ..., 1 게이트 순서로 고려한다
 * i 게이트에 도킹을 완료했을 때 union(i, i-1)를 함으로써 find(i) 의 값이 i 게이트의 root를 가리키도록 만든다
 * 이 root는 곧 빈 게이트, 즉 도킹 가능한 게이트를 의미한다
 * 어떤 값 i에 대해 find(i) == 0 이라면 해당 비행기는 도킹할 게이트가 없음을 의미한다
 *
 */
public class BOJ_10775_공항 {

    static int G, P;
    static int[] parents;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        G = sc.nextInt();  // 게이트 수
        P = sc.nextInt();  // 비행기 수

        // parents[] 배열 초기화
        parents = new int[G+1];
        for (int i = 1; i <= G; i++) {
            parents[i] = i;
        }

        int cnt = 0;  // 도킹 가능한 비행기 갯수
        for (int i = 0; i < P; i++) {
            int n = sc.nextInt();  // 1~n 번 게이트에 도킹 가능

            int emptyGate = find(n);

            if (emptyGate == 0) break;

            cnt++;
            union(emptyGate, emptyGate-1);
        }

        System.out.println(cnt);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // 같은 disjoint set에 포함될 경우 값이 작은 인덱스가 대표가 되도록 설계
        if (rootY > rootX) {
            parents[rootY] = rootX;
        } else {
            parents[rootX] = rootY;
        }
    }

    static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }

}
