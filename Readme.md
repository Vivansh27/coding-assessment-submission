# coding-assessment-submission



### Constraints
- `0 <= s.length <= 3 * 10^4`
- `s[i]` is `'('` or `')'`

## Approach
The solution uses a two-pass, O(1) space approach:

1. **Left-to-right pass** – Track counts of open and close brackets. 
   Whenever `open == close`, we've found a valid substring, so update the max length. 
   If `close > open`, the substring becomes invalid, so reset both counters.

2. **Right-to-left pass** – Needed to catch cases where `'('` count stays 
   greater than `')'` till the end (e.g. `"((("`), which the first pass alone would miss. 
   Same logic applies in reverse.

## Complexity
- **Time Complexity:** O(n) — two linear passes over the string
- **Space Complexity:** O(1) — no extra data structures used

## Files
- `Solution.java` — contains the solution implementation
