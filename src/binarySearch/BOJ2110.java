package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[] house;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        System.out.println(solution(C));
    }

    static int solution(int C) {
        int left = 1;  // 최소 거리가 가질 수 있는 최솟값
        int right = house[house.length - 1] - house[0] + 1;  // 최소 거리가 가질 수 있는 최댓값

        while (left < right) {  // Upper Bound 방식
            int mid = (left + right) / 2;

            // mid 거리로 설치할 수 있는 공유기 개수가 C에 못미치면
            // 거리를 줄여야 한다
            if (canInstall(mid) < C) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // Upper Bound 방식은 탐색 값을 초과하는 첫 번째 값을 가리키므로
        // 1을 빼준 값이 조건식을 만족하는 최댓값이 된다
        return left - 1;
    }

    // 주어진 distance로 설치 가능한 공유기 개수 반환
    static int canInstall(int distance) {
        int count = 1;
        int lastLocate = house[0];

        for (int i = 1; i < house.length; i++) {
            int locate = house[i];

            if (locate - lastLocate >= distance) {
                count++;
                lastLocate = locate;
            }
        }

        return count;
    }
}