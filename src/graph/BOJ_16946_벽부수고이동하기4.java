package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16946_벽부수고이동하기4 {
    static int N, M;
    static int[][] map;
    static int[][] group;
    static Map<Integer, Integer> hashMap;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, - 1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        group = new int[N][M];
        hashMap = new HashMap<>();
        solution();
    }

    static void solution() {
        // 그룹 짓기
        int idx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && group[i][j] == 0) {  // 해당 위치가 0이면서 아직 그룹 지어지지 않은 경우
                    bfs(i, j, idx++);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    sb.append("0");
                } else {
                    sb.append(getCount(i, j));
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void bfs(int startI, int startJ, int groupIdx) {
        Queue<int[]> que = new LinkedList<>();

        que.add(new int[]{startI, startJ});
        group[startI][startJ] = groupIdx;

        int cnt = 1;  // 시작 위치 포함
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int i = cur[0], j = cur[1];

            for (int d = 0; d < 4; d++) {
                int nextI = i + di[d];
                int nextJ = j + dj[d];

                if (nextI < 0 || nextJ < 0 || nextI > N-1 || nextJ > M-1) continue;

                if (map[nextI][nextJ] == 0 && group[nextI][nextJ] == 0) {  // 빈 공간이면서 아직 그룹에 포함되지 않은 위치인 경우
                    que.offer(new int[]{nextI, nextJ});
                    group[nextI][nextJ] = groupIdx;  // 그룹 번호 부여
                    cnt++;
                }
            }
        }

        hashMap.put(groupIdx, cnt % 10);
    }

    static int getCount(int startI, int startJ) {
        int cnt = 1;

        Set<Integer> set = new HashSet<>();
        for (int d = 0; d < 4; d++) {
            int nextI = startI + di[d];
            int nextJ = startJ + dj[d];

            if (nextI < 0 || nextJ < 0 || nextI > N-1 || nextJ > M-1) continue;
            if (map[nextI][nextJ] == 1) continue;

            set.add(group[nextI][nextJ]);  // 사방 탐색을 하면서 같은 그룹이 중복되는 것을 방지하기 위해 Set 구조 사용
        }

        for (int i : set) {
            cnt += hashMap.get(i);  // 해당 그룹에 속한 칸의 갯수를 누적합
        }

        return cnt % 10;
    }

}