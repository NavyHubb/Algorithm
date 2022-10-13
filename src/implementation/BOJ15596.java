package implementation;

public class BOJ15596 {
    public long sum(int[] a) {
        int n = a.length;
        int sum = 0;
        for (int j : a) {
            sum += j;
        }
        return sum;
    }
}
