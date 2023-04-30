package dateStructure.hash;

import java.util.HashMap;
import java.util.Map;

// 완주하지 못한 선수
public class PRO42576 {
    public static void main(String[] args) {

    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        // 각 이름(key)에 등장 횟수(value)를 입력
        for (String player : participant) {
            // map에 player라는 key에 해당하는 value가 있으면 반환하고, 아니면 default value로 설정한 값을 반환
            // 이름이 중복되는 경우도 있기 때문에 이름이 등장할 때마다 value에 +1을 해준다
            map.put(player, map.getOrDefault(player, 0) + 1);
        }

        // 완주한 선수에 대한 value를 차감시켜준다
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        // key들을 돌면서 value가 0이 아닌 key를 탐색한다
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
            }
        }

        return answer;
    }
}
