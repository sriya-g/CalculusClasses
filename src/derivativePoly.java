import java.util.Scanner;
public class derivativePoly {
    static Scanner keyboard = new Scanner(System.in);
    public static String derivePoly(int[] coeffs) {
        String dvdEq = "";
        for (int i = 0; i < coeffs.length; i++) {
            coeffs[i] = coeffs[i]*(coeffs.length - i);
            if ((coeffs.length - i - 1) == 1) {
                dvdEq = dvdEq+(coeffs[i]+"x"+" + ");
            }
            else if ((coeffs.length - i - 1) == 0) {
                dvdEq = dvdEq+(coeffs[i]);
            }
            else {
                dvdEq = dvdEq+(coeffs[i]+"x^"+(coeffs.length - i - 1)+" + ");
            }
        }
        return dvdEq;
    }
    public static void main(String[] args) {
        System.out.print("Enter the degree of your polynomial: ");
        int deg = -1;
        do {
            deg = keyboard.nextInt();
        }
        while(deg <= 0);
        int[] coeffs = new int[deg];
        for (int i = 0; i < coeffs.length; i++) {
            System.out.print("Enter the coefficient of the x^"+(coeffs.length-i)+" term: ");
            coeffs[i] = keyboard.nextInt();
        }
        System.out.println(derivePoly(coeffs));
    }
}
