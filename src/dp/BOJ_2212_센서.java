package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * 고속도로 위에 N개의 센서를 설치했다
 * 최대 K개의 집중국 설치하여 센서의 정보를 수집한다
 * 각 집중국의 수신 가능 영역의 길이의 합을 최소화한 값을 구하라
 *
 * 집중국의 수신 가능영역의 길이는 0 이상
 * 모든 센서의 좌표가 다를 필요는 없다.
 *
 * [문제 풀이]
 * 각 센서 간의 거리 차이 값을 나타내는 배열 diff를 만든다
 * 집중국의 수가 K일 때, 거리 간 차이를 건너뛸 수 있는 횟수는 K-1이다
 * 따라서 diff를 오름차순 정렬하고 가장 작은 수부터 N-(K-1) 개의 합을 구한다
 */
public class BOJ_2212_센서 {

    static int N, K;
    static int[] sensors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        sensors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution());
    }

    private static int solution() {
        Arrays.sort(sensors);

        int[] diff = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            diff[i] = sensors[i+1] - sensors[i];
        }

        Arrays.sort(diff);
        int sum = 0;
        for (int i = 0; i < N-K; i++) {
            sum += diff[i];
        }

        return sum;
    }
}
