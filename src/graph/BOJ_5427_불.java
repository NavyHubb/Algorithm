package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 건물의 일부에 불이 났고, 상근이는 출구를 향해 뛰고 있다
 * 매 초마다 불은 인접사방의 빈 공간으로 확산된다
 * 상근이는 벽을 통과할 수 없고, 불이 있는 칸, 이제 불이 있을 칸으로 이동할 수 없다
 * 얼마나 빨리 빌딩을 탈출할 수 있는지 구하라
 *
 * [문제 풀이]
 *
 */
public class BOJ_5427_불 {

    static int N, M;
    static char[][] map;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static Queue<Point> fires;
    static Queue<Person> people;
    static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    static class Person {
        int i, j, cnt;

        public Person(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            fires = new LinkedList<>();
            people = new LinkedList<>();

            map = new char[N][M];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < M; j++) {
                    char ch = str.charAt(j);
                    if (ch == '@') {  // 상근
                        people.add(new Person(i, j, 0));
                    } else if (ch == '*') {  // 불
                        fires.add(new Point(i, j));
                    }
                    map[i][j] = ch;
                }
            }

            solution();
        }
    }

    private static void solution() {
        int result = -1;
        while (true) {
            // 불 확산
            spread();

            // 상근 이동
            result = move();
            if (result != -1) break;
            if (people.isEmpty()) break;
        }

        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static int move() {
        int size = people.size();
        for (int i = 0; i < size; i++) {
            Person cur = people.poll();

            for (int d = 0; d < 4; d++) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= M) {
                    return cur.cnt + 1;
                }

                if (map[ni][nj] == '.') {
                    map[ni][nj] = '@';
                    people.add(new Person(ni, nj, cur.cnt+1));
                }
            }
        }

        return -1;
    }

    private static void spread() {
        // 현재 저장되어 있는 불의 위치만큼만 수행
        int size = fires.size();
        for (int i = 0; i < size; i++) {
            Point point = fires.poll();

            for (int d = 0; d < 4; d++) {
                int ni = point.i + di[d];
                int nj = point.j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;

                if (map[ni][nj] == '.' || map[ni][nj] == '@') {
                    map[ni][nj] = '*';
                    fires.add(new Point(ni, nj));
                }
            }
        }
    }

}