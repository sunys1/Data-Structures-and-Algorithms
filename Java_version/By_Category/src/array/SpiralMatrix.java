/***
 * 54. https://leetcode.com/problems/spiral-matrix/description/?envType=problem-list-v2&envId=27hvo5e7
 * Use boundary shrinking to iteratively update the 4 boundaries
 */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new LinkedList<>();
        int index = 0, upperBound = 0, lowerBound = m - 1,
                leftBound = 0, rightBound = n - 1;

        while(result.size() < m * n){
            // top
            if(upperBound <= lowerBound){
                for(int j = leftBound; j <= rightBound; j++){
                    result.add(matrix[upperBound][j]);

                }
                // move upperBound down
                upperBound++;
            }
            if(leftBound <= rightBound){
                for(int i = upperBound; i <= lowerBound; i++){
                    result.add(matrix[i][rightBound]);
                }
                // move rightBound left
                rightBound--;
            }
            if(upperBound <= lowerBound){
                for(int j = rightBound; j >= leftBound; j--){
                    result.add(matrix[lowerBound][j]);
                }
                // move lowerBound up
                lowerBound--;
            }
            if(leftBound <= rightBound){
                for(int i = lowerBound; i >= upperBound; i--){
                    result.add(matrix[i][leftBound]);
                }
                // move leftBound right
                leftBound++;
            }
        }

        return result;
    }
}