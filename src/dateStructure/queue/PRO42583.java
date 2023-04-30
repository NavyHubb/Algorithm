package dateStructure.queue;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭
public class PRO42583 {
    public static void main(String[] args) {

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while (true) {
                // 다리 위에 트럭이 한 대도 없는 경우
                if (q.isEmpty()) {
                    q.add(truck);
                    sum += truck;
                    time++;
                    break;
                }
                // 다리가 꽉 찬 경우
                else if (q.size() == bridge_length) {
                    sum -= q.poll();
                    time++;
                }
                // 다리 위에 자리가 남은 경우
                else {
                    // 다리에 다음 트럭이 올라갈 수 있을만큼의 여유 무게가 있는 경우
                    if (sum + truck <= weight) {
                        q.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                    else {
                        q.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}

