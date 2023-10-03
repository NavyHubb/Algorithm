package dateStructure.priorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * [조건]
 * 지금까지 말한 수들 중에서의 중간값을 말해야 한다
 * 외친 수가 짝수인 경우에는 중간에 있는 두 수 중 작은 값을 말한다
 *
 * [풀이]
 * 우선순위 큐를 활용하여 최대힙과 최소힙을 각각 하나씩 마련한다
 * 최소힙과 최대힙의 길이를 같게 유지하면서 입력값을 받는다
 */
public class BOJ_1655_가운데를말해요 {

    static PriorityQueue<Integer> left;
    static PriorityQueue<Integer> right;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();

            if (left.size() == right.size()) left.add(n);
            else right.add(n);  // 두 힙의 길이가 다른 경우는 right의 길이가 더 짧은 경우밖에 없으므로 right에 채워준다

            if (!left.isEmpty() && !right.isEmpty()) {
                if (left.peek() > right.peek()) {
                    int tmp = left.poll();
                    left.add(right.poll());
                    right.add(tmp);
                }
            }

            sb.append(left.peek()).append('\n');
        }

        System.out.println(sb);
    }

}
