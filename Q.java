import java.util.*;

public class Q {

    public static long merge(long[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        long ans = 0;

        long[] L = new long[n1];
        long[] R = new long[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                ans += j;
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            ans += n2;
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        return ans;
    }

    public static long mergeSort(long[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            return mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right) + merge(arr, left, mid, right);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long L = input.nextLong();
        long[] w = new long[n];
        for (int i = 0, u; i < n; i++) {
            w[i] = input.nextInt();
            w[i] = L * w[i] + i;
        }
        System.out.println(mergeSort(w, 0, n - 1));
    }

}