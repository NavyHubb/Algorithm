package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ_2580_스도쿠 {

    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        map = new int[9][];
        for (int i = 0; i < 9; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        solution(0);
    }

    static void solution(int idx) {
        if (idx == 81) {
            print();
            System.exit(0);
        }

        int i = idx / 9;
        int j = idx % 9;

        if (map[i][j] == 0) {
            boolean[] isVisited = new boolean[10];
            for (int k = 0; k < 9; k++) {
                isVisited[map[i][k]] = true;
            }

            for (int k = 1; k <= 9; k++) {
                if(!isVisited[k]) {
                    map[i][j] = k;

                    if (isPromising(i, j)) {
                        solution(idx+1);
                    }
                }
            }
            map[i][j] = 0;
        } else {
            solution(idx+1);
        }
    }

    static boolean isPromising(int i, int j) {
        // 세로 방향 탐색
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for (int k = 0; k < 9; k++) {
            if (map[k][j] != 0) {
                set.add(map[k][j]);
                cnt++;
            }
        }
        if (set.size() != cnt) return false;

        // 3*3 정사각형 탐색
        set = new HashSet<>();
        int startI = (i/3) * 3;  // 정사각형의 좌측상단 위치 구하기
        int startJ = (j/3) * 3;
        cnt = 0;
        for (int k = startI; k < startI+3; k++) {
            for (int l = startJ; l < startJ+3; l++) {
                if (map[k][l] != 0) {
                    cnt++;
                    set.add(map[k][l]);
                }
            }
        }
        if (cnt != set.size()) return false;  // 증복되는 수가 있음을 의미

        return true;
    }

    static void print() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

}