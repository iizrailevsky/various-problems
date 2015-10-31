package com.ilya.coding;



public class RetainPositiveNumbers {

    public static int[] retainPositiveNumbers(int[] a) {
        /*
          Please implement this method to
          return a new array with only positive numbers from the given array.
          The elements in the resulting array shall be sorted in the ascending order.
         */
        int n = 0;
        for (int num : a)
        	if (num > 0)
        		n++;

        int[] result = new int[n];
        n = 0;
        for (int num : a) {
        	if (num > 0) {
        		result[n] = num;
        		n++;
        	}
        }
        sortBubble(result);
        return result;
    }

    private static void sortBubble(int[] res) {
    	int temp;
    	for (int x = 0; x < res.length; x++) {
    		for (int i = 1; i < res.length - x; i++) {
    			if (res[i-1] > res[i]) {
    				temp = res[i-1];
    				res[i-1] = res[i];
    				res[i] = temp;
    			}
    		}
    	}
    }
}
