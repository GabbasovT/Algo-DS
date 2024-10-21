import java.util.Scanner;

public class K {

    public static boolean canDivide(long[] arr, int n, int k, long maxSum) {
        long currentSum = 0;
        int segments = 1;

        for (int i = 0; i < n; i++) {
            if (arr[i] > maxSum) {
                return false;
            }
            if (currentSum + arr[i] > maxSum) {
                segments++;
                currentSum = arr[i];
                if (segments > k) {
                    return false;
                }
            } else {
                currentSum += arr[i];
            }
        }
        return true;
    }

    public static long findMinMaxSum(long[] arr, int n, int k) {
        long left = 0, right = 0;

        for (int i = 0; i < n; i++) {
            right += arr[i];
        }

        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (canDivide(arr, n, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();

        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextLong();
        }

        long minMaxSum = findMinMaxSum(arr, n, k);
        System.out.println(minMaxSum);

        input.close();
    }

}
