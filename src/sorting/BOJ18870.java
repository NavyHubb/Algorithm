package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] origin = new int[n];  // 입력받은 그대로의 원본 배열
        int[] sorted = new int[n];  // 오름차순으로 정렬된 수들이 저장될 배열
        HashMap<Integer, Integer> rankingMap = new HashMap<>();  // key: 수, value: 순위

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++){
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());  // 원본 배열과 정렬할 배열에 값을 넣어준다
        }

        // 위에서 origin 배열과 똑같이 입력받았으므로 정렬 수행
        Arrays.sort(sorted);

        int rank = 0;  // 압축 시 가장 작은 수는 0으로 변환되기 때문에 0부터 시작
        for (int k : sorted) {  // 정렬된 배열에서 해쉬맵에서 key로 쓰일 값들을 하나씩 추출
            // 전에 등장한 적 없는 원소에 대해서만 해쉬맵에 저장
            if (!rankingMap.containsKey(k)) {
                rankingMap.put(k, rank);  // 해쉬맵에 원소와 그에 대응되는 순위를 입력
                rank++;  // 다음 순위를 가리킬 수 있도록 1 증가
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : origin) {
            int ranking = rankingMap.get(key);  // key(수)에 대한 value(순위)를 반환
            sb.append(ranking).append(" ");
        }

        System.out.println(sb);
    }
}