import java.util.Scanner;

public class Matrices{
    private static final int[][] const_matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    private static final int[][] const_matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose input:");
        System.out.println("1. Use constant matrices");
        System.out.println("2. Use custom matrices");
        int choice = scanner.nextInt();

        int rows, columns;
        int[][] m1, m2, m3;

        if (choice == 1) {
            m1 = const_matrix1;
            m2 = const_matrix2;
            rows = m1.length;
            columns = m2.length;
            m3 = new int[rows][columns];
        } else {
            System.out.println("Please enter number of rows in matrix: ");
            rows = scanner.nextInt();
            System.out.println("Please enter number of columns in matrix: ");
            columns = scanner.nextInt();
            m1 = new int[rows][columns];
            m2 = new int[rows][columns];

            System.out.println("Please enter the elements in first matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    m1[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Please enter the elements in second matrix:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    m2[i][j] = scanner.nextInt();
                }
            }
            m3 = new int[rows][columns];
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                m3[i][j] = m1[i][j] + m2[i][j];
            }
        }

        System.out.println("\nThe first matrix is: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(m1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nThe second matrix is: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(m2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nThe sum of the two matrices is: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(m3[i][j] + " ");
            }
            System.out.println();
        }
        scanner.close();
    }
}
