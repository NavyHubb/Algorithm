package dateStructure.hash;

import java.util.HashSet;

// 폰켓몬
public class PRO1845 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4};  // 폰켓못의 종류 번호
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        // set.size() 는 서로 다른 폰켓몬 종류의 수
        return Math.min(set.size(), nums.length / 2);
    }
}