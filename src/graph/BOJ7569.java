package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());  // 가로 칸 수
        int N = Integer.parseInt(st.nextToken());  // 세로 칸 수
        int H = Integer.parseInt(st.nextToken());  // 상자의 수
        
        int[][][] box = new int[H][N][];
        for (int i = 0; i < N*H; i++) {
            int h = i / N;
            int n = i % N;

            box[h][n] = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        }

        System.out.println(bfs(H, N, M, box));
    }

    static int bfs(int H, int N, int M, int[][][] box) {
        Queue<int[]> queue = new LinkedList<>();

        int[][][] visited = new int[H][N][M];
        
        // 안 익은 과일 개수 구하기
        int unriped = 0;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (box[h][i][j] == 1) {
                        visited[h][i][j] = 1;
                        queue.add(new int[]{h, i, j});
                    } else if (box[h][i][j] == -1) {
                        visited[h][i][j] = -1;
                    } else {
                        unriped++;
                    }
                }
            }
        }

        int[] dhArray = {0, 0, 0, 0, 1, -1};
        int[] diArray = {0, 0, 1, -1, 0, 0};
        int[] djArray = {1, -1, 0, 0, 0, 0};

        int days = 0;

        while (!queue.isEmpty()) {
            int t = queue.size();
            days++;

            // 현재 날짜에서 진행될 수 있는 부분 모두 진행
            while (t-- > 0) {
                int[] ints = queue.poll();
                int h = ints[0], i = ints[1], j = ints[2];

                for (int k = 0; k < dhArray.length; k++) {
                    int newH = h + dhArray[k];
                    int newI = i + diArray[k];
                    int newJ = j + djArray[k];

                    if (newH < 0 || newH >= H || newI < 0 || newI >= N || newJ < 0 || newJ >= M) {
                        continue;
                    }

                    if (box[newH][newI][newJ] == 0 && visited[newH][newI][newJ] == 0) {
                        visited[newH][newI][newJ] = days;
                        queue.offer(new int[]{newH, newI, newJ});
                        unriped--;
                    }
                }
            }
        }

        return (unriped == 0) ? days - 1 : -1;
    }
}