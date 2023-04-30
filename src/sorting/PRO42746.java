package sorting;

import java.util.Arrays;

public class PRO42746 {
    public static void main(String[] args) {

    }

    public static String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // 내림차순 정렬
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (arr[0].equals("0")) {
            return "0";
        }

        for (String s : arr) {
            answer += s;
        }

        return answer;
    }
}
