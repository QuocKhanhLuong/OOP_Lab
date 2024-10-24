import javax.swing.JOptionPane;

public class SolveEquations {
    public static void main(String[] args) {
        String strMenu;
        strMenu = JOptionPane.showInputDialog(null, "Equations Option:" + "\n" + "1. Linear Equation" + "\n" + "2. Linear System" + "\n" + "3. Second-degree Equation" + "\n" + "Please enter type of equation:","Input the number", JOptionPane.INFORMATION_MESSAGE);
        double Menu = Double.parseDouble(strMenu);
        if (Menu == 1) {
            // First-degree equation: ax + b = 0
            String strNumA, strNumB;

            strNumA = JOptionPane.showInputDialog(null, "Please enter the coefficient a","Input the first number", JOptionPane.INFORMATION_MESSAGE);
            strNumB = JOptionPane.showInputDialog(null, "Please enter the coefficient b", "Input the second number", JOptionPane.INFORMATION_MESSAGE);

            double a = Double.parseDouble(strNumA);
            double b = Double.parseDouble(strNumB);

            if (a == 0) {
                if (b == 0) {
                    JOptionPane.showMessageDialog(null,"The equation has infinite solutions");
                } else {
                    JOptionPane.showMessageDialog(null,"The equation has no solutions");
                }
            } else {
                double x = -b / a;
                JOptionPane.showMessageDialog(null,String.format("The equation has one solutions: x = %.3f", x));
            }
        } else if (Menu == 2) {
            // Linear system
            String strNum1, strNum2, strNum3, strNum4, strNum5, strNum6;
            strNum1 = JOptionPane.showInputDialog(null, "Please enter the coefficient a11: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
            strNum2 = JOptionPane.showInputDialog(null, "Please enter the coefficient a12: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);
            strNum3 = JOptionPane.showInputDialog(null, "Please enter the coefficient a21: ","Input the third number", JOptionPane.INFORMATION_MESSAGE);
            strNum4 = JOptionPane.showInputDialog(null, "Please enter the coefficient a22: ","Input the fourth number", JOptionPane.INFORMATION_MESSAGE);
            strNum5 = JOptionPane.showInputDialog(null, "Please enter the coefficient b1: ","Input the fifth number", JOptionPane.INFORMATION_MESSAGE);
            strNum6 = JOptionPane.showInputDialog(null, "Please enter the coefficient b2: ","Input the sixth number", JOptionPane.INFORMATION_MESSAGE);

            double a11 = Double.parseDouble(strNum1);
            double a12 = Double.parseDouble(strNum2);
            double a21 = Double.parseDouble(strNum3);
            double a22 = Double.parseDouble(strNum4);
            double b1 = Double.parseDouble(strNum5);
            double b2 = Double.parseDouble(strNum6);

            double D = a11*a22 - a12*a21;
            double D1 = b1*a22 - b2*a12;
            double D2 = a11*b2 - a21*b1;
            if (D == 0) {
                if (D1 == 0 && D2 == 0) {
                    JOptionPane.showMessageDialog(null,"The equation has infinite solutions");
                } else {
                    JOptionPane.showMessageDialog(null,"The equation has no solutions");
                }
            } else {
                double x1 = D1 / D;
                double x2 = D2 / D;
                JOptionPane.showMessageDialog(null,String.format("The equation has one solution:\nx1 = %.3f\nx2 = %.3f", x1, x2));
            }
        } else if (Menu == 3) {
            String strNumA, strNumB, strNumC;

            strNumA = JOptionPane.showInputDialog(null, "Please enter the coefficient a: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(strNumA);
            if(a == 0) {
                JOptionPane.showMessageDialog(null, "This is not a second-degree equation.\nTry linear equation solve instead.");
            } else {
                strNumB = JOptionPane.showInputDialog(null, "Please enter the coefficient b","Input the second number", JOptionPane.INFORMATION_MESSAGE);
                strNumC = JOptionPane.showInputDialog(null, "Please enter the coefficient c","Input the third number", JOptionPane.INFORMATION_MESSAGE);

                double b = Double.parseDouble(strNumB);
                double c = Double.parseDouble(strNumC);
                double delta = b*b - 4*a*c;

                if (delta < 0) {
                    JOptionPane.showMessageDialog(null, "The equation has no solutions");
                } else {
                    if (delta == 0) {
                        double x = -b / (2 * a);
                        JOptionPane.showMessageDialog(null, String.format("The equation has one solution: x = %.3f", x));
                    } else {
                        double x1 = (-b + Math.pow(delta, 0.5)) / (2 * a);
                        double x2 = (-b - Math.pow(delta, 0.5)) / (2 * a);
                        JOptionPane.showMessageDialog(null, String.format("The equation has two solutions:\nx1 = %.3f\nx2 = %.3f", x1, x2));
                    }
                }
            }
        }
        System.exit(0);
    }
}