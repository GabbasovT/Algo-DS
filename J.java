import java.util.*;

public class J {

    static class Pair {
        double s;
        int num;
        Pair(double s, int num) {
            this.s = s;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        long[] v = new long[n];
        long[] w = new long[n];

        for (int i = 0; i < n; i++) {
            v[i] = input.nextLong();
            w[i] = input.nextLong();
        }

        if (n == k) {
            for (int i = 0; i < n; i++) {
                System.out.println(i + 1);
            }
            return;
        }

        double left = 0;
        double right = 1e6 + 1;

        while (right - left > 1e-7) {
            double mid = (left + right) / 2.0;
            Pair[] pairs = new Pair[n];

            for (int i = 0; i < n; i++) {
                pairs[i] = new Pair((v[i] - mid * w[i]), i);
            }
            Arrays.sort(pairs, (a, b) -> Double.compare(b.s, a.s));

            long sumV = 0, sumW = 0;

            for (int i = 0; i < k; i++) {
                sumV += v[pairs[i].num];
                sumW += w[pairs[i].num];
            }
            if (sumV >= mid * sumW) {
                left = mid;
            } else {
                right = mid;
            }
        }

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair((v[i] - left * w[i]), i);
        }

        Arrays.sort(pairs, (a, b) -> Double.compare(b.s, a.s));
        for (int i = 0; i < k; i++) {
            System.out.println(pairs[i].num + 1);
        }
    }
}
