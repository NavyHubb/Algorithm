package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [풀이]
 * 각 문제별 데드라인을 지키면서 가장 많은 보상(컵라면)을 얻는 것이 목적이다
 * 풀 문제를 선택하기 위한 자료구조로 우선순위 큐(pq)를 사용한다
 * 문제의 우선순위는 데드라인이 작을수록(데드라인이 같다면 보상이 클수록) 높다
 * 먼저 문제들을 데드라인 기준 오름차순 정렬한 뒤 순서대로 pq에 삽입한다
 * 이때, [pq.size() > 새로 삽입한 문제의 데드라인]인 경우 pq.poll()을 한다
 * (pq의 사이즈는 pq에 담긴 문제들을 푸는 데 걸리는 시간을 의미하므로)
 * pq.poll()로 삭제되는 문제는
 */
public class BOJ_1781_컵라면 {

    static int N;
    static List<Problem> list;
    static PriorityQueue<Integer> pq;  // prize만 담는다. 추출 시 우선순위는 작은 값부터이다. 결과적으로 마지막까지 남는 값은 보상이 큰 문제들.
    static class Problem implements Comparable<Problem> {
        int deadline, prize;

        public Problem(int deadline, int prize) {
            this.deadline = deadline;
            this.prize = prize;
        }

        @Override
        public int compareTo(Problem o) {
            if (deadline == o.deadline) {
                return -(prize - o.prize);
            }
            return deadline - o.deadline;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int deadline = Integer.parseInt(st.nextToken());
            int prize = Integer.parseInt(st.nextToken());

            list.add(new Problem(deadline, prize));
        }

        System.out.println(solution());
    }

    static long solution() {
        Collections.sort(list);
        for (Problem problem : list) {
            pq.add(problem.prize);

            if (pq.size() > problem.deadline) {
                pq.poll();
            }
        }

        long prizeSum = 0;
        while (!pq.isEmpty()) {
            prizeSum += pq.poll();
        }

        return prizeSum;
    }

}
