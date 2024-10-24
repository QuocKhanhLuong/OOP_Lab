import java.util.Scanner;
import java.util.Arrays;

public class SortingArray {
    private static final int[] const_array = {1,3,5,7,9,2,4,6,8};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose input:");
        System.out.println("1. Use constant array");
        System.out.println("2. Use custom array");
        int choice = sc.nextInt();

        int[] array;
        if (choice == 1) {
            array = Arrays.copyOf(const_array, const_array.length);
            System.out.println(Arrays.toString(array));
        } else {
            System.out.println("Please enter the size of the array: ");
            int size = sc.nextInt();
            array = new int[size];
            System.out.println("Please enter " + size + " numbers: ");
            for (int i = 0; i < size; i++) {
                System.out.println("Number " + (i+1) + ": ");
                array[i] = sc.nextInt();
            }
        }
        Arrays.sort(array);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double avg = (double) sum / array.length;

        System.out.println("\nResults:");
        System.out.println("Sorted array: "+ Arrays.toString(array));
        System.out.println("Sum: " + sum);
        System.out.printf("Average: " + avg);

        sc.close();
    }
}
