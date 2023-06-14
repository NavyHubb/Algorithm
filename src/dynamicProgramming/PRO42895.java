package dynamicProgramming;

public class PRO42895 {
    int answer;

    public int solution(int N, int number) {
        answer = -1;

        dfs(N, number, 0, 0);

        return answer;
    }

    void dfs(int n, int num, int cnt, int prev) {
        if (cnt > 8) {
            return;
        }

        if (prev == num) {
            if (cnt < answer || answer == -1) {
                answer = cnt;
                return;
            }
        }

        int tempN = 0;
        for (int i = 1; i <= 8; i++) {
            tempN = tempN*10 + n;
            dfs(n, num, cnt+i, prev + tempN);
            dfs(n, num, cnt+i, prev - tempN);
            dfs(n, num, cnt+i, prev / tempN);
            dfs(n, num, cnt+i, prev * tempN);
        }
    }

}