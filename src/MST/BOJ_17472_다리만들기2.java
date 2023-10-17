package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [조건]
 * 섬은 연결된 땅이 상하좌우로 붙어있는 덩어리를 말한다(대각선은 붙어있는 것이 아니다)
 * 다리의 조건
 * - 바다에만 건설할 수 있다
 * - 다리의 방향은 가로 또는 세로이다
 * - 다리의 길이는 2 이상이다
 * 모든 섬을 연결하는 다리 길이의 최솟값(불가능하면 -1)을 출력하라
 *
 * 1 <= N, M <= 10
 * 3 <= N*M <= 100
 * 2 <= 섬의 갯수 <= 6
 *
 * [풀이]
 * 모든 섬에 대해 모든 섬으로의 최소 다리 길이를 구해놓고
 * MST를 사용하여 모든 섬들을 연결하는 최소 길이를 구한다
 */
public class BOJ_17472_다리만들기2 {

    static final int INF = 1_000_000_000;
    static int N, M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int islandId;
    static int[] parents;
    static List<Edge> edges;
    static int weightSum;
    static int[] di = {-1, 0, 1, 0};  // 상, 우, 하, 좌
    static int[] dj = {0, 1, 0, -1};
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {  // 가중치 기준 오름차순
            return weight - o.weight;
        }
    }
    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        edges = new ArrayList<>();

        System.out.println(solution());
    }

    static int solution() {
        // 섬 탐색
        islandId = 1;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {  // 아직 방문하지 않은 땅인 경우
                    discoverIsland(i, j, islandId++);
                }
            }
        }

        // 섬들 간의 거리 배열 만들기
        makeBridges();

        // MST를 활용하여 최소 길이로 섬들을 연결
        return MST() ? weightSum : -1;
    }

    /**
     * BFS를 활용하여 주어진 땅의 위치를 시작으로 섬 정보를 구축
     * @param startI 탐색 시작 위치의 행 인덱스
     * @param startJ 탐색 시작 위치의 열 인덱스
     * @param islandId 현재 탐색하고 있는 섬의 id
     */
    static void discoverIsland(int startI, int startJ, int islandId) {
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(startI, startJ));
        map[startI][startJ] = islandId;

        int nextI;
        int nextJ;
        while (!que.isEmpty()) {
            Point cur = que.poll();
            int i = cur.i, j = cur.j;

            for (int d = 0; d < di.length; d++) {
                nextI = i + di[d];
                nextJ = j + dj[d];

                if (nextI < 0 || nextJ < 0 || nextI > N-1 || nextJ > M-1) continue;
                if (map[nextI][nextJ] == 0) continue;  // 땅이 아닌 경우
                if (visited[nextI][nextJ]) continue;  // 이미 방문한 위치인 경우

                visited[nextI][nextJ] = true;
                map[nextI][nextJ] = islandId;  // 섬번호 표시
                que.add(new Point(nextI, nextJ));
            }
        }
    }

    /**
     * 섬 간의 다리 길이를 활용하여 모든 섬을 최소 간선의 길이로 연결하는 최소신장트리 수행
     * @return 모든 섬을 연결할 수 있는지 여부
     */
    static boolean MST() {
        weightSum = 0;  // 다리 길이의 합

        // parents[] 배열 초기화
        parents = new int[K+1];
        for (int i = 1; i <= K; i++) {
            parents[i] = i;
        }

        // 간선 정보 저장
        for (int i = 1; i <= K-1; i++) {
            for (int j = i+1; j <= K; j++) {
                if (dist[i][j] != INF) {
                    edges.add(new Edge(i, j, dist[i][j]));
                }
            }
        }

        // 간선의 길이 기준 오름차순 정렬
        Collections.sort(edges);

        int edgeCnt = 0;  // 선택된 간선의 횟수
        for (Edge edge : edges) {
            if (find(edge.from) == find(edge.to)) continue;  // 이미 연결된 경우

            union(edge.from, edge.to);
            weightSum += edge.weight;
            edgeCnt++;
        }

        return edgeCnt == K-1;
    }

    /**
     * 두 섬을 하나의 집합으로 결합
     */
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootY > rootX) {
            parents[rootY] = rootX;
        } else {
            parents[rootX] = rootY;
        }
    }

    /**
     * 주어진 섬의 root 섬을 탐색
     */
    static int find(int x) {
        if (x == parents[x]) return x;

        return parents[x] = find(parents[x]);
    }

    static void makeBridges() {
        K = islandId-1;  // 섬의 갯수
        dist = new int[K+1][K+1];  // 섬과 섬 사이의 다리 길이
        for (int i = 1; i <= K; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    make(i, j);
                }
            }
        }
    }

    /**
     * 주어진 위치를 기준으로 다리를 설치
     * @param i
     * @param j
     */
    static void make(int i, int j) {
        int startIsland = map[i][j];  // 출발 섬의 번호

        int nextI;
        int nextJ;

        Direction :
        for (int d = 0; d < 4; d++) {
            nextI = i + di[d];
            nextJ = j + dj[d];

            if (!isOutOfRange(nextI, nextJ) && map[nextI][nextJ] == 0) {  // d 방향으로 다리를 놓을 수 있는 경우
                int cnt = 0;
                while (true) {
                    if (isOutOfRange(nextI, nextJ)) {  // 범위를 벗어날 경우 다음 방향 탐색
                        continue Direction;
                    }

                    if (map[nextI][nextJ] != 0) {  // 땅을 만났을 경우
                        if (cnt >= 2) {  // 다리의 길이는 2 이상이어야 한다
                            int endIsland = map[nextI][nextJ];  // 다리를 건너 만나게 된 섬의 id

                            // 두 섬간의 최소 다리 길이 갱신
                            dist[startIsland][endIsland] = Math.min(dist[startIsland][endIsland], cnt);
                            dist[endIsland][startIsland] = Math.min(dist[endIsland][startIsland], cnt);
                        }
                        break;
                    }

                    cnt++;
                    nextI += di[d];
                    nextJ += dj[d];
                }
            }
        }
    }

    /**
     * 주어진 위치가 범위를 벗어날 경우 true 반환
     */
    static boolean isOutOfRange(int i, int j) {
        return i < 0 || j < 0 || i > N-1 || j > M-1;
    }



}