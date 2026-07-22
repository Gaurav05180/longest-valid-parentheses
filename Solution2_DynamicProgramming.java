/**
 * Solution 2 : Dynamic Programming
 *
 * Approach
 * --------
 * dp[i] stores the length of the longest valid parentheses
 * substring ending at index i.
 *
 * Algorithm
 * ---------
 * 1. Create a dp array.
 * 2. Update dp values whenever a valid pair is found.
 * 3. Keep track of the maximum value in dp.
 *
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */

public class Solution2_DynamicProgramming {

    public static int longestValidParentheses(String input) {

        int length = input.length();

        if (length == 0) {
            return 0;
        }

        int[] dp = new int[length];

        int maxLength = 0;

        for (int index = 1; index < length; index++) {

            if (input.charAt(index) != ')') {
                continue;
            }

            // Case : ()
            if (input.charAt(index - 1) == '(') {

                dp[index] = 2;

                if (index >= 2) {
                    dp[index] += dp[index - 2];
                }
            }

            // Case : (())
            else {

                int previousIndex = index - dp[index - 1] - 1;

                if (previousIndex >= 0 && input.charAt(previousIndex) == '(') {

                    dp[index] = dp[index - 1] + 2;

                    if (previousIndex > 0) {
                        dp[index] += dp[previousIndex - 1];
                    }
                }
            }

            maxLength = Math.max(maxLength, dp[index]);
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(longestValidParentheses("(()"));
        System.out.println(longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses(""));
    }
}
