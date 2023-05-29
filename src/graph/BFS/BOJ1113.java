package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(""))
                .mapToInt(Integer::parseInt).toArray();
        }

        System.out.println(solution(map));
    }

    static int solution(int[][] map) {
        int N = map.length;
        int M = map[0].length;
        boolean[][] visited = new boolean[N][M];

        PriorityQueue<Block> pq = new PriorityQueue<>();

        // 우선 테두리 블럭들을 모두 pq에 넣어준다
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || i == N-1 || j == 0 || j == M-1) {
                    pq.offer(new Block(i, j, map[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int water = 0;

        while (!pq.isEmpty()) {
            Block block = pq.poll();  // 가장 높이가 낮은 블럭이 추출된다
            int i = block.i;
            int j = block.j;
            int height = block.height;

            for (int[] dir : dirs) {
                int newI = i + dir[0];
                int newJ = j + dir[1];

                if (newI < 0 || newI > N-1 || newJ < 0 || newJ > M-1 || visited[newI][newJ]) {
                    continue;
                }

                // 주변 블럭 중 가장 낮은 높이(블럭)보다 새로운 블럭의 높이가 낮으면 물을 채울 수 있다
                // 물을 채우고 나면 물을 채운 높이로 블럭의 높이를 갱신해준다
                if (map[newI][newJ] < height) {
                    water += height - map[newI][newJ];
                    map[newI][newJ] = height;
                }
                pq.offer(new Block(newI, newJ, map[newI][newJ]));
                visited[newI][newJ] = true;
            }
        }

        return water;
    }

    static class Block implements Comparable<Block> {
        int i;
        int j;
        int height;

        public Block(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }

        @Override
        public int compareTo(Block o) {
            return this.height - o.height;
        }
    }
}