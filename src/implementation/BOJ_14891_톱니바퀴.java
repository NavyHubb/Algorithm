package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * S극은 1, N극은 0
 * 시계방향 회전은 1, 반시계방향 회전은 -1
 *
 * 맞물린 극이 서로 다른 극이면 회전 발생
 *
 * [문제 풀이]
 * 톱니바퀴의 상태를 나타내는 객체를 생성한다
 * 입력으로 주어진 최초 상태를 기반으로 배열을 생성하고
 * 12시 방향에 있는 톱니바퀴의 인덱스를 나타내는 변수를 마련하여 톱니바퀴의 회전을 구현한다
 */
public class BOJ_14891_톱니바퀴 {

    static Wheel[] wheels;
    static class Wheel {
        boolean[] poles = new boolean[8];  // 각 위치의 극이 S이면 true
        int idx = 0;  // 12시 방향에 위치한 바퀴의 인덱스

        boolean getUp() {
            return poles[idx%8];
        }

        boolean getRight() {
            return poles[(idx+2)%8];
        }

        boolean getLeft() {
            return poles[(idx+6)%8];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 자석 상태 입력
        wheels = new Wheel[5];
        for (int i = 1; i <= 4; i++) {
            String str = br.readLine();

            Wheel wheel = new Wheel();
            for (int j = 0; j < 8; j++) {
                wheel.poles[j] = (str.charAt(j) == '1');
            }
            wheels[i] = wheel;
        }

        // 회전 정보 입력
        int K = Integer.parseInt(br.readLine());  // 회전 횟수
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int wheelIdx = Integer.parseInt(st.nextToken());  // 회전시킬 톱니바퀴의 인덱스
            int direction = Integer.parseInt(st.nextToken());  // 회전 방향

            rotate(wheelIdx, direction);
        }

        // 점수 계산
        int point = 0;
        for (int i = 1; i <= 4; i++) {
            if (wheels[i].getUp()) {
                point += Math.pow(2, i-1);
            }
        }

        System.out.println(point);
    }

    static void rotate(int wheelIdx, int direction) {
        boolean[] visited = new boolean[5];  // 방문 여부
        int[] dirs = new int[5];  // 회전 정보

        // 입력으로 주어진 바퀴부터 회전 시작
        visited[wheelIdx] = true;
        dirs[wheelIdx] = direction;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{wheelIdx, direction});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int idx = cur[0], dir = cur[1];

            int next;
            for (int i = 0; i < 2; i++) {  // 인접 좌우 바퀴에 대해 탐색
                if (i == 0) {
                    next = idx-1;  // 좌측
                    if (next < 1 || next > 4) continue;  // 톱니바퀴들의 범위를 벗어난 경우
                    if (visited[next]) continue;  // 이미 탐색한 톱니바퀴인 경우

                    visited[next] = true;  // 방문 처리
                    if (wheels[idx].getLeft() != wheels[next].getRight()) {  // 맞물린 극이 서로 다른 경우
                        dirs[next] = (dir == 1 ? -1 : 1);
                        queue.add(new int[]{next, dirs[next]});
                    }
                } else {
                    next = idx+1;  // 우측
                    if (next < 1 || next > 4) continue;
                    if (visited[next]) continue;

                    visited[next] = true;  // 방문 처리
                    if (wheels[idx].getRight() != wheels[next].getLeft()) {  // 맞물린 극이 서로 다른 경우
                        dirs[next] = (dir == 1 ? -1 : 1);  // 회전 정보 저장
                        queue.add(new int[]{next, dirs[next]});
                    }
                }
            }
        }

        // 저장해둔 회전 정보에 따라 각 톱니바퀴의 포인터를 이동시킨다
        for (int i = 1; i <= 4; i++) {
            wheels[i].idx -= dirs[i];  // 시계방향(1) 회전 시 포인터는 좌측으로 한칸 이동하기 때문에 dirs[i]에 음의 부호를 붙인다
            wheels[i].idx = (wheels[i].idx + 8)%8;  // ArrayIndexOutOfBounds 에러 발생 방지를 위한 처리
        }
    }

}
