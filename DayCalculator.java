import java.util.Scanner;

public class DayCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month: ");
        String month = sc.nextLine();
        System.out.print("Enter year (in number): ");
        String year = sc.nextLine();
        int yearNumber = Integer.parseInt(year);
        String[] monthName1 = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        String[] monthName2 = {
                "Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sept.", "Oct.",
                "Nov.", "Dec."
        };
        String[] monthName3 = {
                "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month.charAt(0) < '0' || month.charAt(0) > '9') {
            for (int i = 0; i < 12; i++) {
                if (month.equals(monthName1[i])) {
                    if (i + 1 == 2 && ((yearNumber % 4 == 0 && yearNumber % 100 != 0) || yearNumber % 400 == 0)) {
                        System.out.println(29);
                    } else System.out.println(daysInMonth[i]);
                }
                if (month.equals(monthName2[i])) {
                    if (i + 1 == 2 && ((yearNumber % 4 == 0 && yearNumber % 100 != 0) || yearNumber % 400 == 0))
                        System.out.println(29);
                    else System.out.println(daysInMonth[i]);
                }
                if (month.equals(monthName3[i])) {
                    if (i + 1 == 2 && ((yearNumber % 4 == 0 && yearNumber % 100 != 0) || yearNumber % 400 == 0)) {
                        System.out.println(29);
                    } else {
                        System.out.println(daysInMonth[i]);
                    }
                }
            }
        }
    }
}