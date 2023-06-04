package greedy;

import java.io.IOException;
import java.util.Scanner;

public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String[] arr = str.split("");

        int zeroCnt = 0, oneCnt = 0;  // 덩어리의 갯수

        if (arr[0].equals("0")) {
            zeroCnt++;
        } else {
            oneCnt++;
        }

        for (int i = 1; i < arr.length; i++) {
            // 이전 인덱스의 값과 다른 값이 나온 경우
            if (!arr[i-1].equals(arr[i])) {
                // 그 다른 값이 0인 경우
                if (arr[i].equals("0")) {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }
        }

        // 0의 덩어리 갯수과 1의 덩어리 갯수 중 값이 작은 것으로 선택
        int result = Math.min(zeroCnt, oneCnt);

        System.out.println(result);
    }
}