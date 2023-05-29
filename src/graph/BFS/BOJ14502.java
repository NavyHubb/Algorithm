package graph.BFS;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ14502 {
    static int N;  // 지도의 세로 길이
    static int M;  // 지도의 가로 길이
    static int[][] map;  // 원본 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxSafeZone = Integer.MIN_VALUE;  // 안전지역 갯수의 최댓값

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0);

        System.out.println(maxSafeZone);
    }

    // 벽 3개를 세울 수 있는 모든 경우 dfs 탐색
    // 그리고 조건(wallCnt == 3)을 만족하는 모든 각 dfs 경우에 대해 bfs 탐색
    static void dfs(int wallCnt) {
        // 벽 3개가 모두 설치된 경우 bfs 출발
        if (wallCnt == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt+1);
                    map[i][j] = 0;  // 다른 dfs에 영향을 주지 않기 위해 원본 배열 map의 값을 다시 원래대로 돌려놓는다
                }
            }
        }
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        // 바이러스 위치를 큐에 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.add(new Node(i, j));
                }
            }
        }

        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();  // 원본 배열의 변형을 막기위해 deep copy 사용
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x, y = cur.y;

            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 새로운 위치가 map의 범위 내에 있어야 한다
                if (nx >= 0 && ny >= 0 && nx <= N-1 && ny <= M-1) {
                    if (copyMap[nx][ny] == 0) {
                        q.add(new Node(nx, ny));
                        copyMap[nx][ny] = 2;
                    }
                }
            }
        }

        // safeZone의 갯수 탐색하여 최댓값 갱신
        checkSafeZone(copyMap);
    }

    static void checkSafeZone(int[][] copyMap) {
        int safeZoneCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeZoneCnt++;
                }
            }
        }

        // 최댓값 갱신
        if (maxSafeZone < safeZoneCnt) {
            maxSafeZone = safeZoneCnt;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}