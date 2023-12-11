package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1911_흙길보수하기 {

    static int N, L;
    static int[][] waters;  // 웅덩이 정보

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 웅덩이 개수
        L = Integer.parseInt(st.nextToken());  // 널빤지 길이
        waters = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            waters[i][0] = start;
            waters[i][1] = end;
        }

        System.out.println(solution());
    }

    static int solution() {
        Arrays.sort(waters, ((o1, o2) -> {
            return o1[0] - o2[0];
        }));   // 웅덩이의 시작이 빠른 순으로 정렬

        int cnt = 0;
        int start = 0;
        for (int[] water : waters) {
            if (water[0] > start) {
                start = water[0];
            }

            if (water[1] > start) {
                while (water[1] > start) {
                    start += L;
                    cnt++;
                }
            }
        }

        return cnt;
    }

}
