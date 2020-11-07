package com.ilya.coding;

/**
 * Having uniform RNG generating numbers in the range [0, 13) ("rand13()"),
 * produce uniform RNG that will be generating numbers in the range [0, 17) ("rand17()");
 */
public class RandomNumberGen {

    /**
     * Returns random number in range [0, 17)
     * given rand13()
     */
    public static int rand17() {
        return (int) (((double)rand13() / 13) * (17 - 0 + 1));
    }

    /**
     * Returns random number in range [0, 13)
     * @return
     */
    public static int rand13() {
        // return [0, 13)
        return (int) (Math.random() * 13);
    }

    public static void main(String[] args) {
        //System.out.println((int) 15.6);

        for (int i = 0; i < 10; i++) {
            System.out.println(rand17());
        }



    }

}
