import java.util.LinkedList;
import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();
        LinkedList<Character> list = new LinkedList<Character>();
        for (char c : input.toCharArray()) {
            list.add(c);
        }
        boolean isPalindrome = true;
        while (list.size() > 1) {
            if (list.removeFirst() != list.removeLast()) {
                isPalindrome = false;
                break;
            }
        }
        System.out.println("Is Palindrome? : " + isPalindrome);
        scanner.close();
    }
}
