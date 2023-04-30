package sorting;

import java.util.Arrays;
// K번째 수
public class PRO42748 {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int length = commands[i][1] - commands[i][0] + 1;
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr);

            answer[i] = arr[commands[i][2] - 1];
        }

        return answer;
    }
}
