package implementation;

import java.util.Scanner;

public class BOJ2669 {
    static int[] arr;
    static int switchs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        switchs = sc.nextInt();
        arr = new int[switchs+1];

        for (int i = 1; i <= switchs; i++) {
            arr[i] = sc.nextInt();
        }

        int people_cnt = sc.nextInt();
        for (int i = 0; i < people_cnt; i++) {
            int sex = sc.nextInt();
            int num = sc.nextInt();

            if (sex == 1) {
                male(num);
            } else {
                female(num);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= switchs; i++) {
            sb.append(arr[i]).append(' ');
            if (i % 20 == 0) {
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

    static void male(int num) {
        // num의 배수인 스위치 반전
        for (int i = 1; i <= switchs; i++) {
            if (i % num == 0) {
                touch(i);
            }
        }
    }

    static void female(int num) {
        // 좌우 대칭인 스위치 반전
        touch(num);

        int i = 1;
        while (num-i >= 1 && num+i <= switchs) {
            if (arr[num-i] == arr[num+i]) {
                touch(num-i);
                touch(num+i);
                i++;
            } else {
                break;
            }
        }
    }

    static void touch(int num) {
        if (arr[num] == 1) {
            arr[num] = 0;
        } else {
            arr[num] = 1;
        }
    }

}