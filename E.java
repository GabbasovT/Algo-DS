import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E {

    final static int INF = 1_000_000_001;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int u = input.nextInt();
            arr.add(u);
        }

        Collections.sort(arr);
        int q = input.nextInt();

        while (q-- > 0) {
            int l = input.nextInt();
            int r = input.nextInt();

            int leftIndex = lowerBound(arr, l);
            int rightIndex = upperBound(arr, r);
            int result = rightIndex - leftIndex;
            System.out.print(result + " ");
        }
        System.out.println();
        input.close();
    }

    public static int lowerBound(List<Integer> arr, int value) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static int upperBound(List<Integer> arr, int value) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr.get(mid) <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
