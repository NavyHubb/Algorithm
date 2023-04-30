package dateStructure.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> q = new LinkedList<>();  //   Queue로 활용할 연결리스트
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                // {초기 위치, 중요도}
                q.offer(new int[] {i, Integer.parseInt(st.nextToken())});
            }

            int count = 0;

            while (!q.isEmpty()) {
                int[] front = q.poll();  // 가장 앞에 있는 원소
                boolean isMax = true;  // front 원소가 가장 큰 원소인지 판단하는 변수

                for (int i = 0; i < q.size(); i++) {
                    if (front[1] < q.get(i)[1]) {  // q.get(i)의 인덱스 1은 중요도를 가리킨다
                        // 뽑은 원소를 포함한 i번째 원소 이전의 원소들을 뒤로 보낸다
                        q.offer(front);
                        for (int j = 0; j < i; j++) {
                            q.offer(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                // front 원소가 가장 큰 원소가 아닐 경우 다음 반복으로 넘어간다
                if (isMax == false) {
                    continue;
                }

                // front 원소가 가장 큰 원소인 경우 해당 원소는 출력해야 하는 문서다
                count++;
                if (front[0] == M) {  // 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }

            }

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}