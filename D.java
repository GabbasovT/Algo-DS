import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class D {

    public static void insert(ArrayList<Integer> heap, int x) {
        heap.add(x);
        int index = heap.size() - 1;

        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) > heap.get(parentIndex)) {
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public static int extractMax(ArrayList<Integer> heap) {
        int max = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        maxHeapify(heap, 0);
        return max;
    }

    public static void maxHeapify(ArrayList<Integer> heap, int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int largest = index;

        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != index) {
            Collections.swap(heap, index, largest);
            maxHeapify(heap, largest);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int q = input.nextInt();
        ArrayList<Integer> heap = new ArrayList<>();

        while (q-- > 0) {
            int command = input.nextInt();
            if (command == 0) {
                int number = input.nextInt();
                insert(heap, number);
            } else if (command == 1) {
                System.out.println(extractMax(heap));
            }
        }

        input.close();
    }
}
