package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while (true) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            
            if (W == 0 && H == 0) {
                break;
            }
            
            int[][] map = new int[H][];
            for (int i = 0; i < H; i++) {
                map[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            }

            System.out.println(bfs(map, H, W));
        }

    }

    static int bfs(int[][] map, int H, int W) {
        int cnt = 0;

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[H][W];

        int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};  // 상, 하, 좌, 우, 하우, 하좌, 상우, 상좌
        int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};

        // 모든 칸을 돌면서 탐색
        // 땅인 칸을 만나면 그 위치를 시작점으로 BFS 탐색하며 visited 처리
        // 하나의 BFS가 끝나면 카운트+1
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {

                // 아직 방문하지 않았으면서 땅인 경우
                if (!visited[i][j] && map[i][j] == 1) {
                    q.add(new Node(i, j));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        Node cur = q.poll();
                        int x = cur.x, y = cur.y;

                        for (int k = 0; k < dx.length; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            // 새로운 위치가 map의 범위 내에 있어야 한다
                            if (nx >= 0 && ny >= 0 && nx <= W-1 && ny <= H-1) {
                                if (map[ny][nx] == 1 && !visited[ny][nx]) {
                                    q.add(new Node(ny, nx));
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }

                    cnt++;
                }
            }
        }

        return cnt;
    }

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}