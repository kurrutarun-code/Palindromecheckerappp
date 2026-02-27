import java.util.Scanner;

/**
 * ============================================================================
 * MAIN CLASS - UseCase12PalindromeCheckerApp
 * ============================================================================
 *
 * Use Case 12: Strategy Pattern for Palindrome Algorithms
 *
 * Description:
 * This class demonstrates how different palindrome
 * validation algorithms can be selected dynamically
 * at runtime using the Strategy Design Pattern.
 *
 * At this stage, the application:
 * - Defines a common PalindromeStrategy interface
 * - Implements a concrete Stack based strategy
 * - Injects the strategy at runtime
 * - Executes the selected algorithm
 *
 * No performance comparison is done in this use case.
 * The focus is purely on algorithm interchangeability.
 *
 * The goal is to teach extensible algorithm design.
 *
 * @author Developer
 * @version 12.0
 */
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();
        
        // Inject the strategy at runtime
        PalindromeStrategy strategy = new StackStrategy();
        boolean isPalindrome = strategy.check(input);
        
        System.out.println("Is Palindrome? : " + isPalindrome);
        scanner.close();
    }
}

/**
 * ============================================================================
 * INTERFACE - PalindromeStrategy
 * ============================================================================
 *
 * This interface defines a contract for all
 * palindrome checking algorithms.
 *
 * Any new algorithm must implement this interface
 * and provide its own validation logic.
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * ============================================================================
 * CLASS - StackStrategy
 * ============================================================================
 *
 * This class provides a Stack based implementation
 * of the PalindromeStrategy interface.
 *
 * It uses LIFO behavior to reverse characters
 * and compare them with the original sequence.
 */
class StackStrategy implements PalindromeStrategy {

    /**
     * Implements palindrome validation using Stack.
     *
     * @param input String to validate
     * @return true if palindrome, false otherwise
     */
    public boolean check(String input) {
        
        // Create a stack to store characters.
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
        // Push each character of the input string onto the stack.
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        
        // Compare characters by popping from the stack.
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        
        return true;
    }
}
