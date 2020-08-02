package com.ilya.coding;

public class RemoveCharDuplicates {

        public static void main(String[] args) {

            // 1st test case
            //removeCharDuplicates();
        }

        /**
         * Removes duplicate charqcters in a string without additional buffer
         * @param a Char array
         */
        public static void removeCharDuplicates(char[] a) {
            // error checking
            if (a == null || a.length == 0 || a.length == 1) {
                return;
            }

            // init vars
            int n = a.length;
            int tail = 1;

            for (int i = 1; i < n; ++i) {
                int j;
                for (j = 0; j < tail; ++j) {
                    if (a[i] == a[j]) {
                        break;
                    }
                }

                if (j == tail) {
                    a[tail] = a[i];
                    tail++;
                }
            }

            if (tail <= n - 1) {
                a[tail] = 0;
            }
        }


}
