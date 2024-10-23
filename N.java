import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        PriorityQueue<Integer> freeSpaces = new PriorityQueue<>();
        HashMap<Integer, Integer> carToSpace = new HashMap<>();

        for (int i = 1; i <= m; i++) {
            freeSpaces.add(i);
        }

        for (int i = 0; i < m; i++) {
            String operation = scanner.next();
            int carNumber = scanner.nextInt();

            if (operation.equals("+")) {
                int space = freeSpaces.poll();
                carToSpace.put(carNumber, space);
                System.out.println(space);
            } else if (operation.equals("-")) {
                int space = carToSpace.get(carNumber);
                freeSpaces.add(space);
                carToSpace.remove(carNumber);
            }
        }

        scanner.close();
    }
}
