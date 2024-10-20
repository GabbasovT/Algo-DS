import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class A {

    final static int INF = 1_000_000_001;

    public static int parent(int v) {
        return (v - 1) / 2;
    }

    public static void thDown(List<Integer> arr, int v, int n) {
        int left = 2 * v + 1;
        int right = 2 * v + 2;
        int minIndex = v;
        if (left < n && arr.get(left) < arr.get(minIndex)) {
            minIndex = left;
        }
        if (right < n && arr.get(right) < arr.get(minIndex)) {
            minIndex = right;
        }
        if (minIndex != v) {
            Collections.swap(arr, v, minIndex);
            thDown(arr, minIndex, n);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(input.nextInt());
        }
        for (int i = n / 2 - 1; i >= 0; i--) {
            thDown(arr, i, n);
        }
        for (int i = n - 1; i >= 0; i--) {
            Collections.swap(arr, 0, i);
            thDown(arr, 0, i);
        }
        for (int i = n - 1; i > -1; i--) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }
}
