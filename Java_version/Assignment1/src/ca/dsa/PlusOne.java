package ca.dsa;

/***
 * https://leetcode.com/problems/plus-one/description/
 *
 * Time: O(N)
 * Space: O(1) for most cases; O(N) worst case if all digits are 9.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
