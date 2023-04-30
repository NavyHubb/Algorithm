package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {
    static int N, K;
    static int[] visit = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs(N);
        System.out.println(result);
    }

    public static int bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        int n = 0;
        visit[node] = 1;  // 처음 위치(0초) 입력
        while (!q.isEmpty()) {
            n = q.remove();  // 헤드에 있는 원소 추출

            // 해당 위치가 동생의 위치와 일치할 경우
            if (n == K) {
                return visit[n] - 1;  // 0초에서의 위치에 1을 대입했기 때문에 다시 1 만큼 빼준다
            }

            // 해당 위치에서 (X-1) 이동한 경우
            if (n - 1 >= 0 && visit[n - 1] == 0) {
                visit[n - 1] = visit[n] + 1;
                q.add(n - 1);
            }

            // 해당 위치에서 (X+1) 이동한 경우
            if (n + 1 <= 100000 && visit[n + 1] == 0) {
                visit[n + 1] = visit[n] + 1;
                q.add(n + 1);
            }

            // 해당 위치에서 (X*2) 이동한 경우
            if (n * 2 <= 100000 && visit[n * 2] == 0) {
                visit[n * 2] = visit[n] + 1;
                q.add(n * 2);
            }
        }

        // 수행되지 않을 코드이지만 컴파일 오류를 피하기 위한 라인
        return -1;
    }
}