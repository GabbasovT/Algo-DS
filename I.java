import java.util.Scanner;
import java.util.Locale;

public class I {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int Vp = input.nextInt();
        int Vf = input.nextInt();
        double a = input.nextDouble();
        double left = 0, right = 1;
        double eps = 1e-9;

        while (right - left > eps) {
            double mid1 = left + (right - left) / 3;
            double mid2 = right - (right - left) / 3;

            double time1 = calculateTime(mid1, a, Vp, Vf);
            double time2 = calculateTime(mid2, a, Vp, Vf);

            if (time1 < time2) {
                right = mid2;
            } else {
                left = mid1;
            }
        }
        double bestX = (left + right) / 2;
        System.out.printf("%.8f\n", bestX);
    }

    private static double calculateTime(double x, double a, int Vp, int Vf) {
        double t1 = Math.sqrt(Math.pow(x, 2) + Math.pow(a - 1, 2)) / Vp;
        double t2 = Math.sqrt(Math.pow(1 - x, 2) + Math.pow(a, 2)) / Vf;
        return t1 + t2;
    }

}
