package math;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BOJ10101 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int agl1 = sc.nextInt();
        int agl2 = sc.nextInt();
        int agl3 = sc.nextInt();

        if (agl1 + agl2 + agl3 != 180) {
            System.out.println("Error");
            return;
        }

        if (agl1 == 60 && agl2 == 60) {
            System.out.println("Equilateral");
            return;
        }

        List<Integer> triangle = new ArrayList<>();
        triangle.add(agl1);
        triangle.add(agl2);
        triangle.add(agl3);

        HashSet<Integer> triSet = new HashSet<>(triangle);
        if (triSet.size() == 2) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }
}