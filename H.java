import java.util.Scanner;
import java.util.Locale;

public class H {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double C = input.nextDouble();
        double left = 0, right = 100000.1;
        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2;
            if (mid * mid + Math.sqrt(mid) < C) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println(left);
    }
}
