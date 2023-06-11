package bruteForce;

import java.util.Scanner;

public class BOJ3040 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int target = sum - 100;

        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    idx1 = i;
                    idx2 = j;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == idx1 || i == idx2) {
                continue;
            }

            System.out.println(arr[i]);
        }
    }

}