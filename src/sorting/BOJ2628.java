package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ2628 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();

        List<Integer> widthList = new ArrayList<>();
        List<Integer> heightList = new ArrayList<>();

        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            int dir = sc.nextInt();
            int num = sc.nextInt();

            // height에 대해
            if (dir == 0) {
                heightList.add(num);
            } else {
                widthList.add(num);
            }
        }

        Collections.sort(heightList);
        Collections.sort(widthList);

        int heightMax;
        if (!heightList.isEmpty()) {
            heightMax = heightList.get(0);
            for (int i = 1; i < heightList.size(); i++) {
                heightMax = Math.max(heightMax, heightList.get(i) - heightList.get(i-1));
            }
            heightMax = Math.max(heightMax, height - heightList.get(heightList.size()-1));
        } else {
            heightMax = height;
        }

        int widthMax;
        if (!widthList.isEmpty()) {
            widthMax = widthList.get(0);
            for (int i = 1; i < widthList.size(); i++) {
                widthMax = Math.max(widthMax, widthList.get(i) - widthList.get(i-1));
            }
            widthMax = Math.max(widthMax, width - widthList.get(widthList.size()-1));
        } else {
            widthMax = width;
        }

        System.out.println(heightMax * widthMax);
    }

}