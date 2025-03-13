/**
 * 150. https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=problem-list-v2&envId=mr2i5b6
 * Time: O(N)
 * Space: O(N)
 */

// Solution 1: Iterative Stack approach
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for (String s : tokens){
            // check value or operator
            if (isNumeric(s)) st.push(s);
            else{
                int b = Integer.parseInt(st.pop());
                int a = Integer.parseInt(st.pop());
                st.push(String.valueOf(helper(a, b, s)));
            }
        }

        return Integer.parseInt(st.pop());
    }

    private boolean isNumeric(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int helper(int a, int b, String op){
        if(op.equals("+")){
            return a + b;
        }else if(op.equals("-")){
            return a - b;
        }else if(op.equals("*")){
            return a * b;
        }else if(op.equals("/")){
            return a / b;
        }

        return 0;
    }
}

/**
 * Solution 2: Recursive approach
 * time: O(N)
 * Space: O(n): could have deep recursion
 */
class Solution {
    int i;
    public int evalRPN(String[] tokens) {
        i = tokens.length -1;
        return eval(tokens);
    }

    int eval(String[] tokens){

        String s = tokens[i--];

        if(s.equals("+")){
            return eval(tokens) + eval(tokens);
        }
        else if(s.equals("-")){
            return -eval(tokens) + eval(tokens);
        }
        else if(s.equals("*")){
            return eval(tokens) * eval(tokens);
        }
        else if(s.equals("/")){
            int deno = eval(tokens);
            return eval(tokens) / deno;
        }
        else{
            return Integer.parseInt(s);
        }
    }
}