package dateStructure.stack;

import java.util.Arrays;
import java.util.Stack;

// 같은 숫자는 싫어
public class PRO12906 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0 , 1, 1};

        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            // 큐가 비어있을 때
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }

            if (arr[i] != stack.peek()) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];

        int i = stack.size() - 1;
        while (!stack.isEmpty()) {
            answer[i] = stack.pop();
            i--;
        }

        return answer;
    }
}
