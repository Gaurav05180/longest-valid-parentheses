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

        int maxLength = 0;
    
        for (int start = 0; start < input.length(); start++) {
    
            for (int end = start; end < input.length(); end++) {
    
                int currentLength = end - start + 1;
    
                // valid substring length must be even
                if (currentLength % 2 != 0) {
                    continue;
                }
    
                String current = input.substring(start, end + 1);
    
                if (isValid(current)) {
                    maxLength = Math.max(maxLength, currentLength);
                }
            }
        }
    
        return maxLength;
    }
    

    public static void main(String[] args) {

        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
    }
}
