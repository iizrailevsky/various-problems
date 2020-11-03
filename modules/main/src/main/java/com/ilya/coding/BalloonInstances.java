package com.ilya.coding;

/**
 * Given string text, use the chars in text to form
 * instances of the word "balloon" - many as possible
 * Use each char at most once.
 * Return max number of instances of "balloon" to be formed
 *
 * Input: string: text
 * Output: int: number of instances of "balloon"
 * Constraints: text - non-empty, lower case English letters
 * Example: ctext = "nlaebolko", output: 1
 *           text = "loonbalxballpoon", output: 2
 *           text = "leetcode", output: 0
 * Options: Take ASCII letter int value, store in array with number of occurrences
 *          for "balloon" and text.
 *          Apply as many times as possible by decrementing count.
 */
public class BalloonInstances {
    public static int maxNumberOfBalloons(String text) {
        // error checking
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int[] balloonChars = stringToArray("balloon");
        int[] textChars = stringToArray(text);

        int i = 0;
        while (applyBalloonPossible(textChars, balloonChars)) {
            i++;
        }

        return i;
    }

    /**
     * Returns array representation of string of ASCII char values
     */
    private static int[] stringToArray(String text) {
        int[] arr = new int[26];

        char[] chars = text.toCharArray();
        for (char c : chars) {
            arr[(int)(c - 'a')]++;
        }

        return arr;
    }

    /**
     * Apply "balloon" chars to text array.
     * Returns true if fully applicable, false otherwise
     */
    private static boolean applyBalloonPossible(int[] textChars, int[] balloonChars) {
        for (int i = 0; i < 26; i++) {
            if (balloonChars[i] > 0) {
                // enough occurrences of text chars as "balloon"?
                // if so, decrement the number of occurrences
                if (textChars[i] >= balloonChars[i]) {
                    textChars[i] -= balloonChars[i];
                } else {
                    // can't apply "balloon" chars anymore - stop
                    return false;
                }
            }
        }

        // able to apply
        return true;
    }
}
