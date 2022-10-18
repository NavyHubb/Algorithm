package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        System.out.println(solution(A, B, V));
    }

    public static int solution(int up, int down, int goal) {
        int day = (goal - down) / (up - down);  // 목표 높이에서 미끄러진 것이 하루를 올라가고 미끄러졌을 때 올라가는 거리의 몇배인지

        if (((goal - down) % (up - down) ) != 0) {
            day++;
        }

        return day;
    }
}
