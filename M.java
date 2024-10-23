import java.util.Scanner;
import java.util.Arrays;

public class M {

    public static long countingKth(long[] a, long[] sortedB, long value) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            long search = value - a[i];
            int left = -1;
            int right = sortedB.length;
            while (left + 1 < right) {
                int mid = (left + right) >> 1;
                if (sortedB[mid] > search) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            count += right;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] = input.nextLong();
        }
        long[] sortedB = Arrays.copyOf(b, n);
        Arrays.sort(sortedB);
        long left = 1;
        long right = 2_000_000_001L;
        while (left < right) {
            long mid = (left + right) >> 1;
            long count = countingKth(a, sortedB, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }

}