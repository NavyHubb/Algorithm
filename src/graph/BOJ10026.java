package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ10026 {

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] image_blind = new char[N][N];  // 색약이 보는 그림
        char[][] image_notBlind = new char[N][N];  // 색약이 아닌 사람이 보는 그림

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);

                // 색약자가 보는 그림과 색약이 아닌 자가 보는 그림을 따로 만든다
                if (c == 'R' || c == 'G') {
                    image_blind[i][j] = 'R';
                } else {
                    image_blind[i][j] = 'B';
                }
                image_notBlind[i][j] = c;
            }
        }


        int blockCountForNotBlind = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(N, image_notBlind, i, j);
                    blockCountForNotBlind++;
                }
            }
        }

        int blockCountForBlind = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(N, image_blind, i, j);
                    blockCountForBlind++;
                }
            }
        }

        System.out.println(blockCountForNotBlind + " " + blockCountForBlind);
    }

    static void bfs(int N, char[][] image, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        char initValue = image[x][y];

        int[] di = {0, 0, 1, -1};
        int[] dj = {1, -1, 0, 0};

        while (!queue.isEmpty()) {
            int[] ints = queue.poll();
            int i = ints[0], j = ints[1];

            for (int k = 0; k < di.length; k++) {
                int newI = i + di[k];
                int newJ = j + dj[k];

                if (newI < 0 || newI >= N || newJ < 0 || newJ >= N) {
                    continue;
                }

                if (initValue == 'R') {
                    if (image[newI][newJ] == 'R' && !visited[newI][newJ]) {
                        queue.offer(new int[]{newI, newJ});
                        visited[newI][newJ] = true;
                    }
                } else if (initValue == 'G') {
                    if (image[newI][newJ] == 'G' && !visited[newI][newJ]) {
                        queue.offer(new int[]{newI, newJ});
                        visited[newI][newJ] = true;
                    }
                } else {
                    if (image[newI][newJ] == 'B' && !visited[newI][newJ]) {
                        queue.offer(new int[]{newI, newJ});
                        visited[newI][newJ] = true;
                    }
                }
            }
        }
    }

}