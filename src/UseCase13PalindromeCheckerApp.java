import java.util.Scanner;

/**
 * ============================================================================
 * MAIN CLASS - UseCase13PalindromeCheckerApp
 * ============================================================================
 *
 * Use Case 13: Performance Comparison
 *
 * Description:
 * This class measures and compares the execution
 * performance of palindrome validation algorithms.
 *
 * At this stage, the application:
 * - Uses a palindrome strategy implementation
 * - Captures execution start and end time
 * - Calculates total execution duration
 * - Displays benchmarking results
 *
 * This use case focuses purely on performance
 * measurement and algorithm comparison.
 *
 * The goal is to introduce benchmarking concepts.
 *
 * @author Developer
 * @version 13.0
 */
public class UseCase13PalindromeCheckerApp {

    /**
     * Application entry point for UC13.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();
        
        // Capture start time
        long startTime = System.nanoTime();
        
        // Execute palindrome check logic
        boolean isPalindrome = check(input);
        
        // Capture end time
        long endTime = System.nanoTime();
        
        // Calculate duration
        long executionTime = endTime - startTime;
        
        System.out.println("Is Palindrome? : " + isPalindrome);
        System.out.println("Execution Time : " + executionTime + " ns");
        
        scanner.close();
    }
    
    /**
     * Helper method to validate palindrome.
     * Simple two-pointer approach for benchmarking purposes.
     *
     * @param s Input string
     * @return true if palindrome, otherwise false
     */
    private static boolean check(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
