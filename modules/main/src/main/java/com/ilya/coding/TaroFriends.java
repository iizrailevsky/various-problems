package com.ilya.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * TaroFriends: TopCoder
 *
 * Cat Taro likes to play with his cat friends. Each of his friends
 * currently sits on some coordinate on a straight line that goes
 * from the left to the right.
 *
 * When Taro gives a signal, each of his friends must move exactly X units
 * to the left or to the right.
 *
 * You are given an int[] coordinates and the int X.
 * For each i, the element coordinates[i] represents the coordinate
 * of the i-th cat before the movement. Return the smallest possible
 * difference between the positions of the leftmost cat
 * and the rightmost cat after the movement.
 *
 * @author iizrailevsky
 *
 */
public class TaroFriends {

    public TaroFriends() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Returns smallest possible difference between positions
     * of leftmost and rightmost cats after movement if found,
     * -1 otherwise
     * @param positions Positions of cats
     * @param X steps to move for each cat
     * @return smallest distance between leftmost and rightmost cats, -1 otherwise
     */
    public int getSmallestDistance(int[] positions, int X) {
        // error checking
        if (X < 0 || positions == null || positions.length < 0) {
            return -1;
        }

        // init variables
        int size = positions.length;

        // one cat?
        if (size == 1) {
            return 0;
        }

        List<int[]> afterMovePositions = new ArrayList<>();
        // generate after move positions
        generateAfterMovePositoins(positions, 0, X, afterMovePositions);
        // print them
        for (int[] afterMovePosition: afterMovePositions) {
            System.out.println(Arrays.toString(afterMovePosition));
        }

        int minDistance = Integer.MAX_VALUE;
        int minIndex = Integer.MAX_VALUE;
        // find min distance
        for (int i = 0; i < afterMovePositions.size(); i++) {
            int[] afterMovePosition = afterMovePositions.get(i);
            int leftMostPosition = getMin(afterMovePosition);
            int rightMostPosition = getMax(afterMovePosition);
            if ((rightMostPosition - leftMostPosition) < minDistance) {
                minDistance = rightMostPosition - leftMostPosition;
                minIndex = i;
            }
        }

        if (minIndex < Integer.MAX_VALUE) {
            System.out.println("Winning positions: " + Arrays.toString(afterMovePositions.get(minIndex)));
        }
        return minDistance;
    }

    /**
     * Generate after move positions
     * @param positions
     * @param index
     * @param X
     * @param afterMovePositions
     */
    private void generateAfterMovePositoins(int[] positions, int index, int X, List<int[]> afterMovePositions) {
        // error checking
        if (positions == null || index < 0 || X < 0 || afterMovePositions == null) {
            return;
        }

        // base case
        if (index >= positions.length) {
            afterMovePositions.add(positions);
            return;
        }

        // go left
        int[] positionsLeft = Arrays.copyOf(positions, positions.length);
        positionsLeft[index] -= X;
        generateAfterMovePositoins(positionsLeft, index + 1, X, afterMovePositions);

        // go right
        int[] positionsRight = Arrays.copyOf(positions, positions.length);
        positionsRight[index] += X;
        generateAfterMovePositoins(positionsRight, index + 1, X, afterMovePositions);
    }

    /**
     * Returns min in the given array
     * @param positions
     * @return
     */
    private int getMin(int[] positions) {
        // error checking
        if (positions == null) {
            return -1;
        }

        int min = Integer.MAX_VALUE;
        for (int i : positions) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    /**
     * Returns max in the given array
     * @param positions
     * @return
     */
    private int getMax(int[] positions) {
        // error checking
        if (positions == null) {
            return -1;
        }

        int max = Integer.MIN_VALUE;
        for (int i : positions) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] positions = {-3, 0, 1};
        int X = 3;
        System.out.println("Winning smallest distance: " + new TaroFriends().getSmallestDistance(positions, X));
    }

}
