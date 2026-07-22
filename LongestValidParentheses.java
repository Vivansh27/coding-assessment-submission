class Solution {

    public int longestValidParentheses(String s) {
        // Edge case for empty or null string
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0;

        // First pass: traverse left to right
        // Keep track of open and close bracket counts
        int open = 0, close = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            // When open equals close, we found a valid balanced substring
            if (open == close) {
                maxLen = Math.max(maxLen, 2 * close);
            }
            // If close exceeds open, the substring becomes invalid,
            // so reset both counters here
            else if (close > open) {
                open = 0;
                close = 0;
            }
        }

        // Second pass: traverse right to left
        // Needed because a left to right pass alone misses cases
        // where '(' count stays greater than ')' till the end 
        open = 0;
        close = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            }
            else if (open > close) {
                open = 0;
                close = 0;
            }
        }

        return maxLen;
    }

    // Time Complexity: O(n) --> the string is traversed twice (once left to right,
    // once right to left), each pass is linear, so overall it's O(n)
    // Space Complexity: O(1) -> only a few counter variables are used,
    // no extra data structures like stacks or arrays
}
