package dateStructure.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 사과를 먹으면 뱀의 길이가 늘어난다
 * 뱀이 이동하다 벽이나 자기 몸과 부딪히면 게임은 끝난다
 * 이동한 칸에 사과가 있다면 몸의 길이가 늘어나고, 없다면 길이는 그대로이다.
 *
 * 게임을 시작할 때, 뱀은 맨위 좌측에 위치하고 오른쪽을 향한다. 길이는 1이다.
 *
 * 사과의 위치와 이동경로가 주어질 때 게임이 몇 초만에 끝나는지 구하라
 *
 * [문제 풀이]
 * 뱀의 몸이 위치하고 있는 칸의 정보를 deque에 담는다
 * 사과를 만났을 경우, 머리가 전진하고 꼬리는 그대로 남아있으므로 addFirst()만 수행하고
 * 사과가 만나지 않았을 경우, 머리가 전진하고 꼬리도 한칸 전진하므로 기존 꼬리 위치를 removeLast()로 삭제한다
 *
 * 회전 정보는 시간 순으로 입력되므로 queue를 사용하여 head 위치에 있는 값만 비교한다
 */
public class BOJ_3190_뱀 {

    static int N, K, L;
    static boolean[][] map;
    static int[] di = {0, 1, 0, -1};  // 동-남-서-북 (동쪽 방향부터 시계방향 순서)
    static int[] dj = {1, 0, -1, 0};
    static Queue<Turn> turns;
    static Deque<Point> snake;
    static class Turn {
        int t;  // 방향 전환을 할 시점
        int d;  // 회전 방향

        public Turn(int t, int d) {
            this.t = t;
            this.d = d;
        }
    }
    static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());  // 보드의 크기
        K = Integer.parseInt(br.readLine());  // 사과의 개수
        map = new boolean[N][N];

        // 사과의 위치
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x-1][y-1] = true;
        }

        L = Integer.parseInt(br.readLine());  // 방향 전환 횟수
        turns = new LinkedList<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (st.nextToken().equals("L")) {  // 좌회전
                turns.add(new Turn(x, 3));
            } else {  // 우회전
                turns.add(new Turn(x, 1));
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        // 초기 세팅
        snake = new ArrayDeque<>();
        int time = 0, d = 0;

        snake.add(new Point(0, 0));
        while (true) {
            time++;
            Point cur = snake.peekFirst();

            // 다음 위치
            int ni = cur.i + di[d];
            int nj = cur.j + dj[d];

            if (isFinish(ni, nj)) break;

            if (map[ni][nj]) {  // 사과가 있는 경우
                map[ni][nj] = false;  // 사과 삭제
                snake.addFirst(new Point(ni, nj));  // 머리 이동
            } else {  // 사과가 없는 경우
                snake.addFirst(new Point(ni, nj));  // 머리 이동
                snake.removeLast();  // 꼬리 이동
            }

            // 방향 전환 시점이면 방향 전환 시키기
            Turn turn = turns.peek();
            if (turn == null) continue;
            if (turn.t == time) {
                d = (d + turn.d) % 4;
                turns.poll();
            }
        }

        return time;
    }

    private static boolean isFinish(int i, int j) {
        // 범위를 벗어난 경우
        if (i < 0 || j < 0 || i >= N || j >= N) return true;

        // 뱀의 몸에 부딪힌 경우
        for (Point point : snake) {
            if (point.i == i && point.j == j) return true;
        }

        return false;
    }

}
