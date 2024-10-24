import javax.swing.JOptionPane;

public class Calculation {
    public static void main(String[] args) {
        String strNum1, strNum2;

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ","Input the second number", JOptionPane.INFORMATION_MESSAGE);

        double Num1 = Double.parseDouble(strNum1);
        double Num2 = Double.parseDouble(strNum2);
        double Sum = Num1 + Num2;
        double Difference = Num1 - Num2;
        double Product = Num1 * Num2;

        if (Num2 == 0) {
            JOptionPane.showMessageDialog(null, "Please enter another number!");
        } else {
            double Quotient = Num1 / Num2;
            JOptionPane.showMessageDialog(null,"The sum is: " + Sum + "\n" + "The difference is: " + Difference + "\n" + "The product is: " + Product + "\n" + "The quotient is: " + Quotient);
        }
        System.exit(0);
    }
}