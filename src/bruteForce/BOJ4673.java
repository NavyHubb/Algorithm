package bruteForce;

public class BOJ4673 {
    public static void main(String[] args) {
        boolean[] arr = new boolean[10001];  // 인덱스를 숫자 정보로서 이용해야하기 때문에 1부터 10000까지의 자리가 있어야함

        for (int i = 1; i < 10001; i++) {
            int n = d(i);

            if (n < 10001) {
                arr[n] = true;  // boolean 배열 초기화 시 초기값은 false
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 1; j < 10001; j++) {
            if (!arr[j]) {  // false인 값만 반환
                sb.append(j).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static int d(int number) {
        int sum = number;  // number가 한자리 수일 때를 고려하여 sum을 number로 초기화

        while (number != 0) {
            sum = sum + (number % 10);
            number /= 10;
        }

        return sum;
    }
}
