import java.util.*;

/**
 * PalindromeCheckerApp - Comprehensive Use Case Implementation
 * 
 * This application demonstrates multiple approaches to check palindromes
 * spanning different data structures and algorithms.
 * 
 * Use Cases:
 * UC1 - Application Entry & Welcome Message
 * UC2 - Hardcoded Palindrome Check
 * UC3 - Reverse Using Loop
 * UC4 - Character Array Two-Pointer
 * UC5 - Stack-Based Palindrome
 * UC6 - Queue + Stack Comparison
 * UC7 - Deque-Based Optimized Check
 */

public class PalindromeCheckerApp {
    
    // ================= UC1: Application Entry & Welcome Message =================
    // Concepts: Class, main() method, static keyword, System.out.println()
    
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("      PALINDROME CHECKER APP     ");
        System.out.println("=================================");
        System.out.println("Version: 1.0.0");
        System.out.println("Developed for Java OOP Practice");
        System.out.println("System initialized successfully\n");
        
        // Test string
        String testString = "radar";
        
        // ================= UC2: Hardcoded Palindrome Check =================
        // Concepts: String, Method creation, Conditional logic (if-else)
        System.out.println("================= UC2: Hardcoded Palindrome Check =================");
        System.out.println("Testing with hardcoded string: \"" + testString + "\"");
        
        if (isPalindrome(testString)) {
            System.out.println("✓ \"" + testString + "\" is a PALINDROME\n");
        } else {
            System.out.println("✗ \"" + testString + "\" is NOT a palindrome\n");
        }
        
        // ================= UC3: Reverse Using Loop =================
        // Concepts: Loop, String immutability, equals()
        System.out.println("================= UC3: Reverse Using Loop =================");
        String reversed = reverseUsingLoop(testString);
        System.out.println("Original: \"" + testString + "\"");
        System.out.println("Reversed: \"" + reversed + "\"");
        
        if (testString.equals(reversed)) {
            System.out.println("✓ \"" + testString + "\" is a PALINDROME (Loop method)\n");
        } else {
            System.out.println("✗ \"" + testString + "\" is NOT a palindrome (Loop method)\n");
        }
        
        // ================= UC4: Character Array Two-Pointer =================
        // Concepts: char[], Array indexing, Two-pointer technique
        System.out.println("================= UC4: Character Array Two-Pointer =================");
        String testString2 = "level";
        System.out.println("Testing with string: \"" + testString2 + "\"");
        System.out.println("Method: Convert to char[] and use two-pointer approach");
        
        if (isPalindromeUsingTwoPointer(testString2)) {
            System.out.println("✓ \"" + testString2 + "\" is a PALINDROME (Two-Pointer method)\n");
        } else {
            System.out.println("✗ \"" + testString2 + "\" is NOT a palindrome (Two-Pointer method)\n");
        }
        
        // ================= UC5: Stack-Based Palindrome =================
        // Concepts: Stack, LIFO (Last-In-First-Out), push(), pop()
        System.out.println("================= UC5: Stack-Based Palindrome =================");
        String testString3 = "madam";
        System.out.println("Testing with string: \"" + testString3 + "\"");
        System.out.println("Method: Stack-based approach (LIFO)");
        
        if (isPalindromeUsingStack(testString3)) {
            System.out.println("✓ \"" + testString3 + "\" is a PALINDROME (Stack method)\n");
        } else {
            System.out.println("✗ \"" + testString3 + "\" is NOT a palindrome (Stack method)\n");
        }
        
        // ================= UC6: Queue + Stack Comparison =================
        // Concepts: Queue (FIFO), Stack (LIFO), LinkedList implementation
        System.out.println("================= UC6: Queue + Stack Comparison =================");
        String testString4 = "racecar";
        System.out.println("Testing with string: \"" + testString4 + "\"");
        System.out.println("Comparing Queue (FIFO) vs Stack (LIFO) behavior\n");
        
        // Queue processing
        Queue<Character> queue = new LinkedList<>();
        for (char c : testString4.toCharArray()) {
            queue.add(c);
        }
        System.out.println("Queue output (FIFO - First In First Out):");
        Queue<Character> queueCopy = new LinkedList<>(queue);
        System.out.print("  ");
        while (!queueCopy.isEmpty()) {
            System.out.print(queueCopy.poll());
        }
        System.out.println();
        
        // Stack processing
        Stack<Character> stack = new Stack<>();
        for (char c : testString4.toCharArray()) {
            stack.push(c);
        }
        System.out.println("Stack output (LIFO - Last In First Out):");
        Stack<Character> stackCopy = new Stack<>();
        stackCopy.addAll(stack);
        System.out.print("  ");
        while (!stackCopy.isEmpty()) {
            System.out.print(stackCopy.pop());
        }
        System.out.println();
        
        // Palindrome check using queue and stack
        if (isPalindromeUsingQueueAndStack(testString4)) {
            System.out.println("✓ \"" + testString4 + "\" is a PALINDROME (Queue+Stack method)\n");
        } else {
            System.out.println("✗ \"" + testString4 + "\" is NOT a palindrome (Queue+Stack method)\n");
        }
        
        // ================= UC7: Deque-Based Optimized Check =================
        // Concepts: Deque (Double-Ended Queue), ArrayDeque, removeFirst(), removeLast()
        System.out.println("================= UC7: Deque-Based Optimized Check =================");
        String testString5 = "noon";
        System.out.println("Testing with string: \"" + testString5 + "\"");
        System.out.println("Method: Deque-based optimized approach (compare from both ends)\n");
        
        if (isPalindromeUsingDeque(testString5)) {
            System.out.println("✓ \"" + testString5 + "\" is a PALINDROME (Deque method)\n");
        } else {
            System.out.println("✗ \"" + testString5 + "\" is NOT a palindrome (Deque method)\n");
        }
        
        System.out.println("=================================");
        System.out.println("   All use cases executed       ");
        System.out.println("=================================");
    }
    
    // ================= UC2 IMPLEMENTATION =================
    /**
     * UC2: Hardcoded Palindrome Check using simple string manipulation
     * Concepts: Method creation, conditional logic
     * 
     * @param str the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return str.equals(reversed);
    }
    
    // ================= UC3 IMPLEMENTATION =================
    /**
     * UC3: Reverse string using for loop
     * Concepts: Loop, String immutability
     * 
     * @param str the string to reverse
     * @return reversed string
     */
    public static String reverseUsingLoop(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }
    
    // ================= UC4 IMPLEMENTATION =================
    /**
     * UC4: Two-Pointer approach using character array
     * Concepts: char[], Array indexing, Two-pointer technique
     * Efficient comparison without creating new strings
     * 
     * @param str the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeUsingTwoPointer(String str) {
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // ================= UC5 IMPLEMENTATION =================
    /**
     * UC5: Stack-based palindrome check
     * Concepts: Stack<Character>, LIFO (Last-In-First-Out), push(), pop()
     * 
     * Approach:
     * 1. Push all characters onto stack
     * 2. Pop characters one by one
     * 3. Compare with original string characters
     * 
     * @param str the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeUsingStack(String str) {
        Stack<Character> stack = new Stack<>();
        
        // Push all characters onto stack
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        
        // Pop and compare with original string
        for (char c : str.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }
    
    // ================= UC6 IMPLEMENTATION =================
    /**
     * UC6: Queue and Stack comparison approach
     * Concepts: Queue (FIFO), Stack (LIFO), LinkedList implementation
     * 
     * Approach:
     * 1. Add characters to both Queue (FIFO) and Stack (LIFO)
     * 2. Compare dequeue (from queue) vs pop (from stack)
     * 3. If all match, it's a palindrome
     * 
     * @param str the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeUsingQueueAndStack(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        
        // Add characters to both queue and stack
        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        
        // Compare: queue removes from front, stack removes from top
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                return false;
            }
        }
        return true;
    }
    
    // ================= UC7 IMPLEMENTATION =================
    /**
     * UC7: Deque-Based Optimized Check
     * Concepts: Deque (Double-Ended Queue), ArrayDeque, removeFirst(), removeLast()
     * 
     * Approach:
     * 1. Insert all characters into Deque
     * 2. Remove from first and last alternatively
     * 3. Compare until only 0 or 1 element remains
     * 4. Most efficient as we don't iterate from the end
     * 
     * @param str the string to check
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeUsingDeque(String str) {
        Deque<Character> deque = new ArrayDeque<>();
        
        // Insert all characters into deque
        for (char c : str.toCharArray()) {
            deque.add(c);
        }
        
        // Remove and compare from both ends
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}