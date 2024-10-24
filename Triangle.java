import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the height of the triangle: ");
        int iHeight = input.nextInt();

        if(iHeight <= 0) {
            System.out.println("Invalid height!");
        } else {
            int maxWidth = 2*iHeight - 1;

            for(int i = 1; i <= iHeight; i++) {
                int astericks = 2*i - 1;
                int spaces = (maxWidth - astericks) / 2;

                for(int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }
                for(int k = 0; k < astericks; k++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
