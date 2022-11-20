import java.util.Scanner;

public class isContinuous {
    static Scanner keyboard = new Scanner(System.in);
    public static String[] splitEq(String eq) {
        String[] splitE = eq.split("\\+");
        for (int i = 0; i < splitE.length; i++) {
            splitE[i] = splitE[i].trim();
        }
        return splitE;
    }
    public static double evaluateAtC(double c, String[] eq) {
        double[] valuesToAdd = new double[eq.length];
        for (int i = 0; i < eq.length; i++) {
            double exp = 0;
            double coeff = 0;
            if (eq[i].indexOf("^") != -1) {
                exp = Double.parseDouble(eq[i].substring(eq[i].indexOf("^")+1));
                coeff = Double.parseDouble(eq[i].substring(0, eq[i].indexOf("x")));
                valuesToAdd[i] = coeff*Math.pow(c, exp);
            }
            else if (eq[i].indexOf("x") != -1) {
                String coefStr = eq[i].substring(0, eq[i].indexOf("x"));
                if (coefStr.isEmpty()) {
                    valuesToAdd[i] = c;
                }
                else {
                    coeff = Double.parseDouble(coefStr);
                    valuesToAdd[i] = coeff*c;
                }
            }
            else {
                valuesToAdd[i] = Double.parseDouble(eq[i]);
            }
        }
        double valueAtC = 0;
        for (double value : valuesToAdd) {
            valueAtC = valueAtC + value;
        }
        return valueAtC;
    }
    public static boolean isCont(double c, String f1, String f2) {
        String[] eq1 = splitEq(f1);
        String[] eq2 = splitEq(f2);
        double val1 = evaluateAtC(c, eq1);
        double val2 = evaluateAtC(c, eq2);
        return (val1 == val2);
    }
    public static void main(String[] args) {
        System.out.println("Enter a value c where piecewise function f(x) changes pieces: ");
        double c = keyboard.nextDouble();
        System.out.println("Enter the piece of f(x) before c: ");
        String func1 = keyboard.nextLine();
        func1 = keyboard.nextLine();
        System.out.println("Enter the piece of f(x) after c: ");
        String func2 = keyboard.nextLine();
        if (isCont(c, func1, func2)) {
            System.out.println("f(x) is continuous at "+c);
        }
        else {
            System.out.println("f(x) is not continuous at "+c);
        }
    }
}
