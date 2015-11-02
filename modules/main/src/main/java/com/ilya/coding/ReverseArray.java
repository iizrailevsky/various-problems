package com.ilya.coding;

public class ReverseArray {

    public static Object[] reverseArray(Object[] a) {
        /*
          Please implement this method to
          return a new array where the order of elements has been reversed from the original
          array.
         */
         Object[] res = new Object[a.length];
         int i = 0;
         for (int j = a.length - 1; j >= 0; i++, j--) {
         	res[i] = a[j];
         }
         return res;
    }
}
