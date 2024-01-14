package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138_전구와스위치 {

    static final int INF = Integer.MAX_VALUE;
    static int N;
    static boolean[] now_on, goal, now_off;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String str1 = br.readLine();
        String str2 = br.readLine();

        now_on = new boolean[N];
        now_off = new boolean[N];
        goal = new boolean[N];

        int cnt_on = 1, cnt_off = 0;  // 스위치를 켜는 경우의 누른 횟수와 끄는 경우의 누른 횟수

        for (int i = 0; i < N; i++) {
            now_on[i] = str1.charAt(i) == '1' ? true : false;
            now_off[i] = now_on[i];
            goal[i] = str2.charAt(i) == '1' ? true : false;
        }

        // 첫번째 스위치를 켜는 경우: 첫번째 전구와 두번째 전구가 상태가 바뀐다
        now_on[0] = !now_on[0];
        now_on[1] = !now_on[1];

        // 두번째 스위치부터 탐색
        for (int i = 1; i < N; i++) {
            if (now_on[i-1] != goal[i-1]) {  // 현재 스위치의 위치의 좌측 전구의 상태가 목표 상태와 다르다면
                // 현재 스위치 on
                now_on[i-1] = !now_on[i-1];
                now_on[i] = !now_on[i];
                if (i < N-1) {  // 마지막 스위치가 아닌 경우에만 i+1 전구에 접근. ArrayOutOfIndex 방지
                    now_on[i+1] = !now_on[i+1];
                }

                cnt_on++;
            }

            if (now_off[i-1] != goal[i-1]) {  // 현재 스위치의 위치의 좌측 전구의 상태가 목표 상태와 다르다면
                // 현재 스위치 on
                now_off[i-1] = !now_off[i-1];
                now_off[i] = !now_off[i];
                if (i < N-1) {  // 마지막 스위치가 아닌 경우에만 i+1 전구에 접근. ArrayOutOfIndex 방지
                    now_off[i+1] = !now_off[i+1];
                }

                cnt_off++;
            }
        }

        if (now_on[N-1] != goal[N-1]) cnt_on = INF;
        if (now_off[N-1] != goal[N-1]) cnt_off = INF;

        if (cnt_on == INF && cnt_off == INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(cnt_on, cnt_off));
        }
    }

}
