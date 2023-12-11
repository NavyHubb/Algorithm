package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 하루에 일어나는 인구이동은 다음과 같다
 * - 국경선을 공유하는 두 나라의 인구차이가 L명 이상 R명 이하라면, 두 나라가 공유하는 국경선이 하루동안 열린다
 * - 국경선이 열리면 인구이동이 시작된다
 * - 국경선이 열린 상태에서 인접한 모든 칸은 하나의 연합으로 묶인다
 * - 연한을 이루고 있는 각 칸의 인구수는 (연합의 총 인구수)/(연합을 이루고 있는 칸의 개수)로 재분배된다
 * - 연합을 해체하고 모든 국경선을 닫는다
 *
 * 인구 이동이 며칠 동안 발생하는지 구하라
 *
 * [풀이]
 * 좌측상단 칸부터 모든 칸을 돌면서 각 칸으로부터 인접 사방 탐색을 통해 연합 국가들을 찾는다(BFS 활용)
 * 방문한 칸에 대해서는 방문처리
 * 방문처리된 칸이 하나도 없을 때까지 반복하며 카운트
 *
 */
public class BOJ_16234_인구이동 {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static boolean isMove;
    static int[] di = {0, 0, -1, 1};
    static int[] dj = {-1, 1, 0, 0};
    static boolean isCompleted = false;
    static List<int[]> unionList;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        }

        solution();
        System.out.println(result);
    }

    static void solution() {
        isMove = true;
        while (true) {
            simulateOneDay();

            if (isMove) {
                result++;
            } else {
                return;
            }
        }
    }

    static void simulateOneDay() {
        visited = new boolean[N][N];
        isMove = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    int sum = bfs(i, j);
                    if (unionList.size() > 1) {
                        popMove(sum);
                    }
                }
            }
        }
    }

    static int bfs(int startI, int startJ) {
        unionList = new ArrayList<>();
        int cnt = 0;  // 연합인 칸의 갯수
        int sum = 0;  // 연합인 인구의 총합

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startI, startJ});
        unionList.add(new int[]{startI, startJ});
        visited[startI][startJ] = true;
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int i = cur[0], j = cur[1];
            cnt++;
            sum += map[i][j];

            for (int d = 0; d < 4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];

                if (ni < 0 || nj < 0 || ni >= N || nj >= N) continue;
                if (visited[ni][nj]) continue;

                int diff = Math.abs(map[i][j] - map[ni][nj]);
                if (!(L <= diff && diff <= R)) continue;

                que.add(new int[]{ni, nj});
                unionList.add(new int[]{ni, nj});
                visited[ni][nj] = true;
                isMove = true;
            }
        }

        return sum;
    }

    static void popMove(int sum) {
        // 연합인 칸에 대해서 인구 갱신
        int newPop = sum / unionList.size();
        for (int[] loc : unionList) {
            map[loc[0]][loc[1]] = newPop;
        }
    }

}