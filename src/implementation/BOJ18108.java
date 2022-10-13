package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ18108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(br.readLine());
        int answer = y - 543;
        System.out.println(answer);
    }
}
