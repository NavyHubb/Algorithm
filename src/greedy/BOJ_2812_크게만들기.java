package greedy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2812_크게만들기 {

    static int N, K;
    static String num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        num = sc.next();

        solution();
    }

    static void solution() {
        Deque<Integer> deque = new ArrayDeque<>();

        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = num.charAt(i) - '0';
        }

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (K > 0 && !deque.isEmpty() && cur > deque.getLast()) {
                deque.removeLast();
                K--;
            }
            deque.addLast(cur);
        }

        StringBuilder sb = new StringBuilder();
        while (deque.size() > K) {
            sb.append(deque.removeFirst());
        }

        System.out.println(sb);
    }

}
