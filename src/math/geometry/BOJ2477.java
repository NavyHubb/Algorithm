package math.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] input = new int[6];

        int maxR = 0, maxC = 0;  // 최대 가로(Row) 길이, 최대 세로(Col) 길이
        int indexR = 0, indexC = 0;

        StringTokenizer st;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());  // 방향
            int dis = Integer.parseInt(st.nextToken());  // 거리

            if (dir == 3 || dir == 4) {
                maxR = Math.max(maxR, dis);
                if (maxR == dis) {
                    indexR = i;
                }
            }
            else {
                maxC = Math.max(maxC, dis);
                if (maxC == dis) {
                    indexC = i;
                }
            }
            input[i] = dis;
        }

        int nextR1 = input[5], nextR2 = input[0];
        int nextC1 = input[5], nextC2 = input[0];

        if (indexC - 1 > -1) {
            nextR1 = input[indexC - 1];
        }
        if (indexC + 1 < 6) {
            nextR2 = input[indexC + 1];
        }
        if (indexR - 1 > -1) {
            nextC1 = input[indexR - 1];
        }
        if (indexR + 1 < 6) {
            nextC2 = input[indexR + 1];
        }

        int area = maxC * Math.min(nextR1, nextR2) + Math.min(nextC1, nextC2) * (maxR - Math.min(nextR1, nextR2));

        System.out.println(area * K);
    }
}