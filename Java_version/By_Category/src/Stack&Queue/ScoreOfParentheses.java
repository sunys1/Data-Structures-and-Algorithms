/**
 * 856. https://leetcode.com/problems/score-of-parentheses/description/
 */

// Solution 1: Stack approach - exchange space for time
class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0); // scoring base

        for (char c : s.toCharArray()){
            if(c == '('){
                st.push(0); // add new scoring level
            }else{
                int score = Math.max(2 * st.pop(), 1);
                st.push(st.pop() + score);
            }
        }

        return st.pop();
    }
}

// Solution 2: O(1) space

class Solution {
    public int scoreOfParentheses(String s) {
        int score = 0, depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth; // 2^depth
                }
            }
        }

        return score;
    }
}