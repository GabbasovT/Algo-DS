import java.util.Scanner;

public class L {

    public static long countLessEqual(long mid, long n) {
        long count = 0;
        for (long i = 1; i <= n; i++) {
            count += Math.min(mid / i, n);
        }
        return count;
    }

    public static long findKthNumber(long n, long k) {
        long left = 1, right = n * n + 1;
        while (left < right) {
            long mid = (right + left) / 2;
            if (countLessEqual(mid, n) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        System.out.println(findKthNumber(n, k));
        scanner.close();
    }
}
