package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2470_두용액 {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        solution();
    }

    private static void solution() {
        Arrays.sort(nums);

        int leftIdx = 0;
        int rightIdx = N-1;
        int leftValue = nums[leftIdx];
        int rightValue = nums[rightIdx];
        int gap = Integer.MAX_VALUE;

        int sum;
        int abs;
        while (leftIdx < rightIdx) {
            sum = nums[leftIdx] + nums[rightIdx];
            abs = Math.abs(sum);
            if (abs < gap) {
                gap = abs;
                leftValue = nums[leftIdx];
                rightValue = nums[rightIdx];
            }

            if (sum > 0) {
                rightIdx--;
            } else {
                leftIdx++;
            }
        }

        System.out.println(leftValue + " " + rightValue);
    }

}
