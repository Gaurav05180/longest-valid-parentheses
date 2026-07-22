import java.util.Stack;

/**
 * Solution 1 : Brute Force
 *
 * Approach
 * --------
 * Generate all possible substrings and check whether each substring
 * forms a valid parentheses sequence. Keep track of the maximum
 * valid substring length found during the process.
 *
 * Algorithm
 * ---------
 * 1. Generate every possible substring.
 * 2. Ignore substrings with odd length.
 * 3. Check whether the substring is valid.
 * 4. Update the maximum valid length.
 *
 * Time Complexity : O(n^3)
 * Space Complexity : O(n)
 */



public class Solution1_BruteForce {

    private static boolean isValid(String text) {
            Stack<Character> stack = new Stack<>();
        
            for (char ch : text.toCharArray()) {
        
                if (ch == '(') {        
                    stack.push(ch);        
                } else {        
                    if (stack.isEmpty()) {
                        return false;
                    }        
                    stack.pop();
                }
            }
        
            return stack.isEmpty();
        }

    public static int longestValidParentheses(String input) {

        // TODO: Implement

        return 0;
    }

    public static void main(String[] args) {

        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
    }
}
