package ca.dsa;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/pascals-triangle-ii/description/
 *
 * Time: O(N)
 * Space: O(N) - only 1-D list needs to be maintained
 *
 * Using the math formula for calculating column values, improving time complexity.
 * Encounterd integer overflow issue at rowIndex = 30. The int type in Java is 32-bit.
 * Somehow this error wasn't triggered in PascalTriangle 1 even if the upper boundary includes numRows = 30.
 * Updated the long value handling in both questions.
 */

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        // Constraints say 0 <= numRows <= 33, which could cause overflow.
        long colValue = 1L; // Alwayus 1 for columnn 1
        row.add((int) colValue);

        if (rowIndex == 0) { return row; }

        // Run rowIndex times to get other column values.
        for (int col = 1; col <= rowIndex; col++){
            colValue = colValue * (rowIndex - col + 1) / col;
            row.add((int) colValue);
        }
        return row;
    }
}

// Easy to think of based on Q118, but less time-efficient: Time O(N^2),  Space O(N)

//public List<Integer> getRow(int rowIndex) {
//    List<Integer> firstRow = new ArrayList<>();
//    firstRow.add(1); // Base row
//
//    List<Integer> rowAbove = firstRow;
//    // Run rowIndex times gives exactly the rowIndex'th row
//    for (int i = 0; i < rowIndex; i++){
//        List<Integer> newRow = buildRow(rowAbove);
//        rowAbove = newRow;
//    }
//    return rowAbove;
//}
//
//public List<Integer> buildRow(List<Integer> rowAbove){
//    List<Integer> row = new ArrayList<>();
//    row.add(1); // Always 1 for column 1
//    for(int j = 0; j < rowAbove.size() - 1; j++){
//        row.add(rowAbove.get(j) + rowAbove.get(j + 1));
//    }
//    row.add(1); // Always 1 for last element of the row
//    return row;
//}