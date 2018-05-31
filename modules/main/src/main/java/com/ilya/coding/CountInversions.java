package com.ilya.coding;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountInversions {

    // Complete the countInversions function below.
    static long countInversions(int[] arr, boolean useMergeSort) {
        // error checking
        if (arr == null || arr.length == 0) {
            return 0;
        }

        if (useMergeSort) {
            int[] temp = new int[arr.length];
            return mergeSort(arr, temp, 0, arr.length - 1);
        } else {
            return quickSort(arr, 0, arr.length - 1);
        }

    }

    private static int quickSort(int[] arr, int lowIndex, int highIndex) {
        int i = lowIndex;
        int j = highIndex;
        int count = 0;

        // calculate pivot index as middle
        int pivot = arr[lowIndex + (highIndex - lowIndex) / 2];

        // divide into 2 arrays
        while (i <= j) {
            // identify elements on left that are > pivot and
            // elements on right that are < pivot, then swap them
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (arr[i] != arr[j]) { count ++; }
                // move index to the next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() recursively
        if (j > lowIndex) {
            count += quickSort(arr, lowIndex, j);
        }
        if (i < highIndex) {
            count += quickSort(arr, i, highIndex);
        }
        return count;
    }

    private static long mergeSort(int[] arr, int[] temp, int lowIndex, int highIndex) {
        long count = 0;
        if (lowIndex < highIndex) {
            int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
            // sort left side
            count += mergeSort(arr, temp, lowIndex, middleIndex);
            // sort right side
            count += mergeSort(arr, temp, middleIndex + 1 , highIndex);
            // merge both sides
            count += mergeParts(arr, temp, lowIndex, middleIndex, highIndex);
        }
        return count;
    }

    private static long mergeParts(int[] arr, int[] temp, int lowIndex, int middleIndex, int highIndex) {
        long count = 0;
        // copy temp array from original
        for (int i = lowIndex; i <= highIndex; i++) {
            temp[i] = arr[i];
        }

        // merge sub-arrays from temp to original in order
        int i = lowIndex;
        int j = middleIndex + 1;
        int k = lowIndex;
        while (i <= middleIndex && j <= highIndex) {
            // left lower?
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                // right is lower than left-hand side
                // count how many elements it's lower
                count += middleIndex + 1 - i;
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // any left on left side? right side is in place already
        while (i <= middleIndex) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr, true);
            System.out.println(Arrays.toString(arr));

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
