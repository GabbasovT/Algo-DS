import java.util.Scanner;

public class F {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        for (int i = 0; i < k; i++) {
            int q = input.nextInt();
            System.out.println(findClosest(arr, q));
        }
        input.close();
    }

    public static int findClosest(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (arr[mid] == target) {
                return arr[mid];
            }
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int closest = arr[l];
        if (l > 0 && Math.abs(arr[l - 1] - target) <= Math.abs(arr[l] - target)) {
            closest = arr[l - 1];
        }
        return closest;
    }
}
