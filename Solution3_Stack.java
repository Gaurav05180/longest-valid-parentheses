import java.util.Stack;

/**
 * Solution 3 : Stack
 *
 * Approach
 * --------
 * Store indices in a stack.
 * Whenever a valid substring is formed,
 * calculate its length using the current index.
 *
 * Algorithm
 * ---------
 * 1. Push -1 as the starting index.
 * 2. Push index of every '('.
 * 3. For every ')', pop one element.
 * 4. If the stack becomes empty, push current index.
 * 5. Otherwise update the maximum length.
 *
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */

public class Solution3_Stack {

    public static int longestValidParentheses(String input) {

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int maxLength = 0;

        for (int index = 0; index < input.length(); index++) {

            if (input.charAt(index) == '(') {

                stack.push(index);

            } else {

                stack.pop();

                if (stack.isEmpty()) {

                    stack.push(index);

                } else {

                    int currentLength = index - stack.peek();

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
