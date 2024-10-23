import java.util.Scanner;

public class S {

    static boolean canKillAllMonsters(long mid, int n, long p, long q, long[] healths) {
        long hitsNeeded = 0;
        for (long health : healths) {
            if (health > mid * q) {
                hitsNeeded += (health - mid * q + (p - q) - 1) / (p - q);
            }
            if (hitsNeeded > mid) {
                return false;
            }
        }
        return hitsNeeded <= mid;
    }

    static long minHitsToKillMonsters(int n, long p, long q, long[] healths) {
        long left = -1;
        long right = 0;
        for (long health : healths) {
            right = Math.max(right, health);
        }
        while (left + 1 < right) {
            long mid = (left + right) / 2;

            if (canKillAllMonsters(mid, n, p, q, healths)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long p = scanner.nextLong();
        long q = scanner.nextLong();
        long[] healths = new long[n];
        for (int i = 0; i < n; i++) {
            healths[i] = scanner.nextLong();
        }
        if (p == q) {
            long m = 0;
            for (long health : healths) {
                m = Math.max(m, health);
            }
            System.out.println((m + q - 1) / q);
            return;
        }
        System.out.println(minHitsToKillMonsters(n, p, q, healths));
        scanner.close();
    }

}
