package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14658_하늘에서별똥별이빗발친다 {

    static int N, M, L, K;
    static int[][] map;
    static Star[] stars;
    static class Star {
        int i, j;

        public Star(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public boolean isCovered(int r, int c, int L) {
            return Math.abs(r-i) <= L/2 && Math.abs(c-j) <= L/2;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stars = new Star[K];
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            stars[k] = new Star(i, j);
        }

        System.out.println(solution());
    }

    static int solution() {
        int max = 0;  // 트램펄린의 범위 내에 포함되는 별똥별의 최대 개수

        for (Star s1 : stars) {
            for (Star s2 : stars) {
                int cnt = boundStar(s1.i, s2.j);
                max = Math.max(max, cnt);
            }
        }

        return K-max;
    }

    /**
     * 트램펄린 범위의 좌상단 위치가 주어졌을 때, 그 범위에 포함되는 별의 개수를 반환한다
     */
    static int boundStar(int i, int j) {
        int cnt = 0;
        for (Star star : stars) {
            if ((i <= star.i && star.i <= i+L) && (j <= star.j && star.j <= j+L)) {
                cnt++;
            }
        }
        return cnt;
    }

}
