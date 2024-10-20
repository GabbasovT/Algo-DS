import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] counter = new int[101];
        for (int i = 0, u; i < n; i++) {
            u = input.nextInt();
            counter[u]++;
        }
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < counter[i]; j++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}