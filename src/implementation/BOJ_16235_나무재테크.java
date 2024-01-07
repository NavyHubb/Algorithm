package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * N*N 크기의 공간, 나무의 개수 M
 * 가장 처음에 양분은 모든 칸에 5만큼 들어있다
 * 한 칸에 여러 나무가 심어져 있을 수 있다
 *
 * 봄: 자신의 나이만큼 양분을 먹고, 나이가 1 증가. 자신이 위치한 칸에 있는 양분만 먹을 수 있으며 나이가 어린 나무부터 양분을 먹는다. 양분을 먹지 못하면 죽는다
 * 여름: 죽은 나무가 양분으로 변한다. 나이를 2로 나눈 값(소수점은 버림)만큼의 양분이 추가된다
 * 가을: 나이가 5의 배수인 나무의 인접 팔방에 나무가 번식한다
 * 겨울: A 배열에 따라 각 칸에 양분이 추가된다
 *
 * K 년이 지난 후 살아남은 나무의 수를 구하라
 */
public class BOJ_16235_나무재테크 {

    static int N, M, K;
    static int[][] A, map;
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};  // 12시 방향부터 시계방향 순서
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    static Deque<Tree> trees = new ArrayDeque<>();
    static class Tree implements Comparable<Tree> {
        int x, y, age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return age - o.age;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1][N+1];
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            trees.add(new Tree(x, y, age));
        }

        System.out.println(solution());
    }

    private static int solution() {
        while (K-- > 0) {
            Queue<Tree> deadTrees = new LinkedList<>();  // 죽은 나무 목록

            // 봄
            for (int i = 0; i < trees.size();) {
                Tree cur = trees.poll();  // 나이가 가장 작은 나무를 추출
                if (map[cur.x][cur.y] >= cur.age) {
                    map[cur.x][cur.y] -= cur.age;
                    cur.age++;
                    i++;
                    trees.add(cur);
                } else {  // 먹을 양분이 충분치 않으면 죽는다
                    deadTrees.add(cur);
                }
            }

            // 여름
            for (Tree tree : deadTrees) {
                map[tree.x][tree.y] += tree.age/2;
            }

            // 가을
            Queue<Tree> tmpList = new LinkedList<>();
            for (Tree tree : trees) {
                if (tree.age % 5 == 0) {
                    tmpList.add(tree);
                }
            }
            while (!tmpList.isEmpty()) {
                Tree cur = tmpList.poll();
                for (int d = 0; d < 8; d++) {
                    int nx = cur.x + di[d];
                    int ny = cur.y + dj[d];

                    if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                    trees.addFirst(new Tree(nx, ny, 1));  // 나이가 가장 작은 1이므로 맨앞에 추가
                }
            }

            // 겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] += A[i][j];
                }
            }
        }

        return trees.size();
    }

}
