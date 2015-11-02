package com.ilya.coding;

public class CountWords {

    public static int countWords(String s) {
        /*
          Please implement this method to
          return the word count in a given String.
          Assume that the parameter String can only contain spaces and alphanumeric characters.
         */
         int count = 0;
         char[] ch = s.toCharArray();

         for (int i = 0; i < ch.length; i++) {
         	if (ch[i] == ' ' || ch[i] == '\0') {
         		count++;
         	}
         }
         return count;
    }
}
