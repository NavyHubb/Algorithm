package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];  // 입력받은 값 누적합
        }

        Arrays.sort(arr);  // 오름차순 정렬

        // 산술평균
        int mean = (int) Math.round((double) sum/arr.length);

        // 중앙값
        int median = arr[(N-1)/2];

        // 최빈값
        int count = 0;  // 어떤 숫자가 출현한 횟수
        int max = -1;  // count의 최댓값을 저장
        int mode = arr[0];
        boolean check = false;
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i+1]) {
                count++;
            } else count = 0;

            if (count > max) {  // 새로운 최대 빈도값 등장
                max = count;
                mode = arr[i];
                check = true;
            } else if (max == count && check == true) {  // 이미 존재하는 최대 빈도값과 같은 값이 최초로 등장
                mode = arr[i];
                check = false;  // false로 설정해놓음으로써 기존 최대 빈도값과 같은 값이 다시 등장했을 때 그 값을 무시할 수 있음. 즉 두번째 등장한 값을 최종 mode로 설정할 수 있음
            }
        }

        sb.append(mean).append("\n").append(median).append("\n").append(mode).append("\n").append(arr[N-1] - arr[0]);

        System.out.println(sb);
    }
}
