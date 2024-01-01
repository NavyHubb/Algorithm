package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [문제 분석]
 * N개의 단어가 주어졌을 때, 어떤 K개의 글자를 가르쳐야 가장 많은 단어를 읽을 수 있을까.
 * 읽을 수 있는 최대 단어의 갯수를 구하라
 *
 * [문제 풀이]
 * 'anta'와 'tica'를 읽는데 필요한 5개 알파벳을 사전에 visited[]에 방문처리를 해놓고
 * 나머지 글자에 대해 모든 경우의 수를 고려한다
 */
public class BOJ_1062_가르침 {

    static int N, K;
    static String[] words;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        visited = new boolean[26];  // 알파벳 갯수만큼의 길이로 배열 생성

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            words[i] = str;
        }

        if (K < 5) {
            System.out.println(0);
            return;
        } else if (K == 26) {
            System.out.println(N);
            return;
        }

        solution();
        System.out.println(max);
    }

    private static void solution() {


        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['c' - 'a'] = true;

        dfs(0, 0);
    }

    private static void dfs(int depth, int start) {
        if (depth == K - 5) {
            int cnt = count();
            max = Math.max(max, cnt);
            return;
        }

        for (int i = start; i < 26; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    private static int count() {
        int cnt = 0;

        Loop: for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!visited[word.charAt(i) - 'a']) continue Loop;
            }
            cnt++;
        }

        return cnt;
    }

}
