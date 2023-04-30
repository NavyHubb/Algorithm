package dateStructure.hash;

import java.util.Arrays;
import java.util.HashSet;

public class PRO42577 {
    public static void main(String[] args) {
        String[] arr = {"119", "97674223", "1195524421"};

        System.out.println(solution(arr));
    }

    public static boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String s : phone_book) {
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
