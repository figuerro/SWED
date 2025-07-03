import java.util.Scanner;

public class Ulam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        // Prompt the user for input between 1 and 999,999
        while (n < 1 || n > 999_999) {
            System.out.print("Enter a positive integer between 1 and 999999: ");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n < 1 || n > 999_999) {
                    System.out.println("Number must be between 1 and 999999.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear invalid input
            }
        }

        long current = n; // Use long to avoid overflow
        System.out.print("Collatz sequence: " + current);

        // Apply the Ulam/Collatz function and print each step
        while (current != 1) {
            if (current % 2 == 0) {
                current /= 2;
            } else {
                current = 3 * current + 1;
            }
            System.out.print(" -> " + current + "\n");
        }
        System.out.println("\nSequence terminated at 1.");
    }
}
