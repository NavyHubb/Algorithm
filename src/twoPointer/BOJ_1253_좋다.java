package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * [조건]
 * 어떤 수가 다른 수 두 개의 합으로 나타낼 수 있으면 좋은 수라고 한다
 * 수의 위치가 다르면 값이 같아도 다른 수이다
 *
 * [풀이]
 * 주어진 수들을 오름차순 정렬하고
 * 투포인터로 각 수를 만들 수 있는지 탐색한다
 * 음수가 주어질 수도 있음에 유의!
 */
public class BOJ_1253_좋다 {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution());
    }

    static int solution() {
        int cnt = 0;  // 좋은 수의 갯수

        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            if (isGood(i)) cnt++;
        }

        return cnt;
    }

    static boolean isGood(int idx) {
        int target = nums[idx];

        int left = 0;
        int right = N-1;

        while (left < right) {
            if (left == idx) {
                left++;
                continue;
            }

            if (right == idx) {
                right--;
                continue;
            }

            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return true;
            }
        }

        return false;
    }


}
