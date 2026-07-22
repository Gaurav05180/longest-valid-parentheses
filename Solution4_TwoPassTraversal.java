/**
 * Solution 4 : Two Pass Traversal
 *
 * Approach
 * --------
 * Count opening and closing brackets while scanning
 * the string from both directions.
 *
 * Algorithm
 * ---------
 * 1. Scan from left to right.
 * 2. Reset counters if closing brackets become more.
 * 3. Scan from right to left.
 * 4. Reset counters if opening brackets become more.
 * 5. Keep updating the maximum valid length.
 *
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */

public class Solution4_TwoPassTraversal {

    public static int longestValidParentheses(String input) {

        int left = 0;
        int right = 0;
        int maxLength = 0;

        // Left to Right
        for (int index = 0; index < input.length(); index++) {

            if (input.charAt(index) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {

                maxLength = Math.max(maxLength, 2 * right);

            } else if (right > left) {

                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        // Right to Left
        for (int index = input.length() - 1; index >= 0; index--) {

            if (input.charAt(index) == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {

                maxLength = Math.max(maxLength, 2 * left);

            } else if (left > right) {

                left = 0;
                right = 0;
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
