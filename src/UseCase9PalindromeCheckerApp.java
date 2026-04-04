import java.util.Scanner;

/**
 * ============================================================================
 * MAIN CLASS - UseCase9PalindromeCheckerApp
 * ============================================================================
 *
 * Use Case 9: Recursive Palindrome Checker
 *
 * Description:
 * This class validates a palindrome using recursion.
 *
 * Characters are compared from the outer positions
 * moving inward using recursive calls.
 *
 * The recursion stops when:
 * - All characters are matched, or
 * - A mismatch is found.
 *
 * This use case demonstrates divide-and-conquer
 * logic using method recursion.
 *
 * @author Developer
 * @version 9.0
 */
public class UseCase9PalindromeCheckerApp {

    /**
     * Application entry point for UC9.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();
        
        boolean isPalindrome = check(input, 0, input.length() - 1);
        
        System.out.println("Is Palindrome? : " + isPalindrome);
        scanner.close();
    }

    /**
     * Recursively checks whether a string is palindrome.
     *
     * @param s     Input string
     * @param start Starting index
     * @param end   Ending index
     * @return true if palindrome, otherwise false
     */
    private static boolean check(String s, int start, int end) {
        // Base case: if start crosses or equals end, all characters matched
        if (start >= end) {
            return true;
        }
        // If characters at current positions don't match, it's not a palindrome
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        // Recursive step: move inward
        return check(s, start + 1, end - 1);
    }
}
