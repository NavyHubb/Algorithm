package dateStructure.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class PRO42587 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 9, 1, 1, 1};

        System.out.println(solution(arr, 2));
    }

    public static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location) {
                        answer++;
                        return answer;
                    }

                    pq.poll();
                    answer++;
                }
            }
        }

        return -1;
    }
}
