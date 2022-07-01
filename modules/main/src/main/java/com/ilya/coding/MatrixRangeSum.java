package com.ilya.coding;

/**
 * Given a 2D matrix matrix, handle multiple queries of the following type:
 *
 * Calculate the sum of the elements of matrix inside the rectangle defined by its upper * left corner (row1, col1) and lower right corner (row2, col2).
 *
 * Options: Create a running sum matrix in constructor.
 *          Then calculate sum of region by going through
 *          the rows from row1 through row2. Subtract
 *          col2 - (col1 - 1) if available || col2 if col1 is the first col.
 *          Time: O(n), Space: O(n^2)
 */
public class MatrixRangeSum {

    private int[][] m;

    public NumMatrix(int[][] matrix) {
        int rN = matrix.length;
        int cN = matrix[0].length;

        m = new int[rN][cN];

        // populate the running sum matrix
        for (int r = 0; r < rN; r++) {
            m[r][0] = matrix[r][0];
            for (int c = 1; c < cN; c++) {
                m[r][c] = m[r][c - 1] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // init vars
        int sum = 0;

        // go over the rows
        for (int r = row1; r <= row2; r++) {
            if (col1 != 0) {
                sum += m[r][col2] - m[r][col1 - 1];
            } else {
                sum += m[r][col2];
            }
        }

        return sum;
    }
}
