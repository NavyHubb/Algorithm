package math.geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(br.readLine());

        System.out.printf("%.6f%n", Math.pow(r, 2) * Math.PI);
        System.out.printf("%.6f", Math.pow(r, 2) * 2);
    }
}