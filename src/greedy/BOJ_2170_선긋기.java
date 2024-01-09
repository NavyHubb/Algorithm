package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2170_선긋기 {

    static int N;
    static Line[] lines;
    static class Line implements Comparable<Line> {
        int from, to;

        public Line(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Line o) {
            return from - o.from;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        lines = new Line[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines[i] = new Line(a, b);
        }

        System.out.println(solution());
    }

    private static int solution() {
        // 선분의 시작 위치 기준 오름차순 정렬
        Arrays.sort(lines);

        // 가장 먼저 시작하는 선분 기준으로 초기화
        int min = lines[0].from;
        int max = lines[0].to;
        int sum = max - min;

        // 두 번째 선분부터 탐색 시작
        for (int i = 1; i < N; i++) {
            Line cur = lines[i];

            if (cur.from >= min && cur.to <= max) {
                continue;
            }

            if (cur.from > max) {  // 선분 추가
                sum += cur.to - cur.from;
            } else if (cur.to > max) {  // 선분 확장
                sum += cur.to - max;
            }

            min = cur.from;
            max = cur.to;
        }

        return sum;
    }

}