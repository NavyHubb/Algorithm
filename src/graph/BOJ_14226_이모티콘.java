package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * [조건]
 * 이미 화면에 이모티콘 1개를 입력했다
 * 이제부터 다음 3가지 연산만 가능하다
 * 1. 화면에 있는 전체 이모티콘을 복사해서 클립보드에 저장
 * 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
 * 3. 화면에 있는 이모티콘 중 하나를 삭제
 *
 * 모든 연산은 1초가 걸린다.
 * 클립보드에 이모티콘을 복사하면 이전에 있던 내용은 덮어쓰기가 된다
 * 클립보드가 비어있는 상태에서는 붙여넣기를 할 수 없다
 * 일부만 클립보드에 복사할 수는 없다
 *
 * 화면에 S개의 이모티콘을 만드는 데 걸리는 최솟값을 구하라
 *
 * [풀이]
 * 이모티콘의 개수만 맞추면 되므로 각 연산을 다음과 같이 단순화
 * 화면 상 이모티콘의 갯수: x, 클립보드 상 이모티콘의 갯수: y
 * 1. y = x
 * 2. x += y
 * 3. x -= 1
 */
public class BOJ_14226_이모티콘 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        System.out.println(solution(S));
    }

    static int solution(int S) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[1001][1001];

        que.add(new int[]{1, 0});
        visited[1][0] = true;

        int cnt = 0;
        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                int[] cur = que.poll();
                int d = cur[0], c = cur[1];

                if (d == S) return cnt;

                for (int i = 0; i < 3; i++) {
                    int nd = d, nc = c;
                    if (i == 0) {  // 연산1. 화면에 있는 전체 이모티콘을 복사해서 클립보드에 저장
                        nc = d;
                    } else if (i == 1) {  // 연산2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
                        if (c == 0) continue;  // 클립보드가 비어있는 경우 건너뛴다
                        nd += c;
                    } else {  // 연산3. 화면에 있는 이모티콘 중 하나를 삭제
                        if (d <= 0) continue;
                        nd -= 1;
                    }

                    if (nd > 1000 || nc > 1000) continue;
                    if (visited[nd][nc]) continue;  // 이미 방문한 위치(개수)인 경우
                    visited[nd][nc] = true;
                    que.add(new int[]{nd, nc});
                }
            }
            cnt++;
        }

        return -1;
    }

}