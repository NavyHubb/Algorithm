package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [풀이]
 * 보상 기준 내림차순으로 강의 목록을 정렬하고
 * 가장 큰 보상을 가진 강의부터 우선순위 큐에 삽입한다
 * 우선순위 큐에 강의를 삽입하고 나서의 큐 사이즈가 방금 넣은 강의의 데드라인보다 클 경우
 */
public class BOJ_2109_순회강연 {

    static int N;
    static Lecture[] lectures;
    static class Lecture implements Comparable<Lecture> {
        int deadline, prize;

        public Lecture(int deadline, int prize) {
            this.deadline = deadline;
            this.prize = prize;
        }

        @Override
        public int compareTo(Lecture o) {
            if (deadline == o.deadline) {
                return -(prize - o.prize);  // 보상 기준 내림차순
            }
            return deadline - o.deadline;  // 데드라인 빠른 순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        lectures = new Lecture[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(d, p);
        }

        System.out.println(solution());
    }

    static int solution() {
        Arrays.sort(lectures);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Lecture lecture : lectures) {
            pq.add(lecture.prize);

            if (pq.size() > lecture.deadline) {  // 방금 넣은 강의의 데드라인보다 큐의 사이즈가 더 큰 경우. 큐의 사이즈는 곧 큐에 담긴 강의들을 수행하는 데 걸리는 시간이다.
                while (pq.size() > lecture.deadline) {
                    pq.poll();
                }
            }
        }

        int prizeSum = 0;
        for (int prize : pq) {
            prizeSum += prize;
        }

        return prizeSum;
    }

}
