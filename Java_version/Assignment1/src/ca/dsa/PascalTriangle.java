package ca.dsa;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * Time: O(N^2)
 * Space: O(N^2)
 *
 * A bit tricky at first to get over the 'Exceeded Memory Limit' error
 * when I implement the nested for loop directly using the math formula with factorials
 * because it causes overflow. It took me some time to convert the pattern to code.
 */

public class PascalTriangle {
    // Constraints say numRows <= 30, which could cause overflow.
    public long value = 1L;
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();

        firstRow.add((int) value); // Always 1 in first row
        result.add(firstRow);

        List<Integer> newRow = new ArrayList<>();
        List<Integer> rowAbove = firstRow;
        // Starting row 2, we can build rows
        for (int i = 1; i < numRows; i++){
            newRow = buildRow(rowAbove);
            result.add(newRow);
            rowAbove = newRow;
        }
        return result;
    }

    public List<Integer> buildRow(List<Integer> rowAbove){
        List<Integer> row = new ArrayList<>();
        row.add((int) value); // Always 1 for column 1

        for(int j = 0; j < rowAbove.size() - 1; j++){
            row.add(rowAbove.get(j) + rowAbove.get(j + 1));
        }
        row.add(1); // Always 1 for last element of the row
        return row;
    }
}
