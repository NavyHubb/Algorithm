package dateStructure.hash;

import java.util.HashMap;
import java.util.Iterator;

public class PRO42578 {
    public static void main(String[] args) {
        String[][] arr = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
    }

    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String[] s : clothes) {
            map.put(s[1], map.getOrDefault(s[1], 0) + 1);
        }

        Iterator<Integer> quantity = map.values().iterator();
        int answer = 1;  // 반복문에서 곱셈을 해주기 때문에 0이 아닌 1로 초기화

        while (quantity.hasNext()) {
            answer *= quantity.next() + 1;
        }

        return answer - 1;  // 아무것도 입지 않는 경우는 제외
    }
}
