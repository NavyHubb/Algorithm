package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ16236 {
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        bfs();
    }

    static void bfs() {
        // 아기상어의 초기 위치
        int[] cur = null;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 9) {
                    cur = new int[]{i, j};

                    arr[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int size = 2;
        int eat = 0;
        int move = 0;

        while (true) {
            // {y좌표, x좌표, 움직인 거리}
            // 움직인 거리가 작은 것부터
            // 거리가 같다면 가장 위에 있는 물고기(y좌표 오름차순)
            // y좌표도 같다면 가장 왼쪽에 있는 물고기(x좌표 오름차순)
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : ( o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]) ));


            boolean[][] visit = new boolean[N][N];
            que.add(new int[]{cur[0], cur[1], 0});
            visit[cur[0]][cur[1]] = true;

            boolean ck = false;  // 상어가 먹이를 먹었는지

            while (!que.isEmpty()) {
                cur = que.poll();

                // 먹이가 있으면서 그 크기가 먹을 수 있는 크기라면
                if (arr[cur[0]][cur[1]] != 0 && arr[cur[0]][cur[1]] < size) {
                    arr[cur[0]][cur[1]] = 0;
                    eat++;
                    move += cur[2];
                    ck = true;
                    break;
                }

                for (int k = 0; k < 4; k++) {
                    int ny = cur[0] + dy[k];
                    int nx = cur[1] + dx[k];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || visit[ny][nx] || arr[ny][nx] > size) {
                        continue;
                    }

                    que.add(new int[]{ny, nx, cur[2] + 1});
                    visit[ny][nx] = true;
                }
            }

            // 큐를 다 비우는 동안 먹은 물고기가 없다면 엄마상어한테 GG
            if (!ck) {
                break;
            }

            // 자기 몸집만큼 먹었다면 레벨업
            if (eat == size) {
                size++;
                eat = 0;
            }
        }

        System.out.println(move);
    }
}