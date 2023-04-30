package dateStructure.hash;

import java.util.*;

// 베스트앨범
public class PRO42579 {
    public static void main(String[] args) {

    }

    public static int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> map = new HashMap<>();

        // 장르별 총 재생 횟수를 나타내는 map 생성
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        // map에서 키값(장르)만 추출하여 genre라는 리스트에 입력
        ArrayList<String> genre = new ArrayList<>();
        for (String key : map.keySet()) {
            genre.add(key);
        }
        Collections.sort(genre, (o1, o2) -> map.get(o2) - map.get(o1));  // value 값을 기준으로 내림차순 정렬

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < genre.size(); i++) {
            String g = genre.get(i);

            // 해당 장르(g)의 음악 중에서 play 값이 첫번째로 큰 인텍스를 찾는다
            int max = 0;
            int firstIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (g.equals(genres[j]) && plays[j] > max) {
                    max = plays[j];
                    firstIdx = j;
                }
            }

            max = 0;
            int secondIdx = -1;
            for (int j = 0; j < genres.length; j++) {
                if (g.equals(genres[j]) && plays[j] > max && j != firstIdx) {
                    max = plays[j];
                    secondIdx = j;
                }
            }

            list.add(firstIdx);
            if (secondIdx >= 0) {  // secondIdx 값이 갱신되지 않았다면 두번째 값이 존재하지 않는 것
                list.add(secondIdx);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
