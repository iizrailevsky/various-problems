package com.ilya.coding;

/*
* String reversal
* Ilya Izrailevsky
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringReversal {

    // string
    private String str;

    public StringReversal(String str) {
        this.str = str;
    }

    public String reverse() throws Exception {
        if (str == null || str.length() == 0) {
            System.err.println("No characters specified!");
            throw new Exception("No characters specified!");
        }

        char[] chars = str.toCharArray();
        // first reverse the whole string
        reverse(chars, 0, chars.length - 1);

        int i = 0;
        for (int j = 0; j < chars.length; j++) {
            // found a space?
            if (chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
        }
        if (i < chars.length) {
            reverse(chars, i, chars.length - 1);
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        char temp;
        while (i < j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] argv) throws Exception {
        // read number sequence
        System.out.print("Enter a word sequence: ");
        String words = (new BufferedReader(new InputStreamReader(System.in))).readLine();

        StringReversal sr = new StringReversal(words);
        String reverse = sr.reverse();
        System.out.println("Reversed string: " + reverse);
    }

}