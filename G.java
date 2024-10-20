import java.util.Scanner;

public class G {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        int y = input.nextInt();
        n--;
        long l = -1, r = n * Math.min(x, y) + 1;
        while (l + 1 < r) {
            long mid = (l + r) >> 1;
            if ((mid / x) + (mid / y) < n) {
                l = mid;
            } else {
                r = mid;
            }
        }
        System.out.println(r + Math.min(x, y));
    }

}