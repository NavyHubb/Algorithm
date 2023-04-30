package bruteForce;

public class PRO86491 {
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int w = 0;
        int h = 0;

        for (int[] size : sizes) {
            // 주어진 명함의 긴 부분은 가로, 짧은 부분은 세로로 지정한다
            // 새로운 명함을 탐색하며 가로, 세로 값의 최댓값을 갱신한다
            w = Math.max(Math.max(size[0], size[1]), w);
            h = Math.max(Math.min(size[0], size[1]), h);
        }

        return w * h;
    }
}
