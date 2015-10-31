package com.ilya.coding;

public class CapitalizeFirstLetters {

    public static String capitalizeFirstLetters(String s) {
        /*
          Please implement this method to
          capitalize all first letters of the words in the given String.
          All other symbols shall remain intact. If a word starts not with a letter, it shall remain intact too.
          Assume that the parameter String can only contain spaces and alphanumeric characters.

          NOTE: please keep in mind that the words can be divided by single or multiple spaces.
          The spaced also can be found at the beginning or the end of the parameter string,
          and you need to preserve them.
         */
        StringBuffer buf = new StringBuffer();
        char prev = ' ';
        for (int i = 0; i < s.length(); i++) {
        	char ch = s.charAt(i);
        	if (Character.isLetter(ch) && prev == ' ') {
        		buf.append(Character.toUpperCase(ch));
        	} else {
        		buf.append(ch);
        	}
        	prev = ch;
        }
        return buf.toString();
    }
}
