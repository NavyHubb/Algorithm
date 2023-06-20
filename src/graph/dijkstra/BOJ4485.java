package graph.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ4485 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            int[][] data = new int[N][];
            for (int i = 0; i < N; i++) {
                data[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            }

            System.out.println("Problem " + cnt + ": " + solution(N, data));
            cnt++;
        }
    }

    static int solution(int N, int[][] data) {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] dijk = new int[N][N];
        for (int[] arr : dijk) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.offer(new Point(0, 0, data[0][0]));
        dijk[0][0] = data[0][0];

        while (!pq.isEmpty()) {
            Point cur = pq.poll();

            for (int[] dir : dirs) {
                int newI = cur.row + dir[0];
                int newJ = cur.col + dir[1];

                if (newI >= 0 && newJ >= 0 && newI <= N-1 && newJ <= N-1) {
                    if (dijk[newI][newJ] > dijk[cur.row][cur.col] + data[newI][newJ]) {
                        dijk[newI][newJ] = dijk[cur.row][cur.col] + data[newI][newJ];
                        pq.offer(new Point(newI, newJ, dijk[newI][newJ]));
                    }
                }
            }
        }

        return dijk[N-1][N-1];
    }

    static class Point implements Comparable<Point> {
        int row;
        int col;
        int weight;

        public Point(int row, int col, int weight) {
            this.row = row;
            this.col = col;
            this.weight = weight;
        }

        @Override
        public int compareTo(Point o) {
            return weight - o.weight;
        }
    }

}