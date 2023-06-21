package math.geometry;

import java.util.Scanner;

public class BOJ11758 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        int value = (x1*y2 + x2*y3 + x3*y1) - (y1*x2 + y2*x3 + y3*x1);

        if (value < 0) {
            System.out.println(-1);
        } else if (value > 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

}