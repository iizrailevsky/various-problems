package com.ilya.coding;

import java.util.*;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // error checking
        if (coins.length == 0 || amount < 0) {
            return -1;
        }

        // init variables
        int count = 0;
        int numCoins = 0;
        int amt = 0;

        // sort coins in asc order
        Arrays.sort(coins);

        // go over coins in desc order and count
        for (int i = 1; i <= coins.length; i++) {
            amt = amount;
            count = 0;
            numCoins = 0;
            for (int x = coins.length - i; x >= 0 && amt > 0; x--) {
                numCoins = amt / coins[x];
                if (numCoins > 0) {
                    count += numCoins;
                }
                amt %= coins[x];
            }
            if (amt == 0) {
                break;
            }
        }

        if (amt > 0) {
            return -1;
        } else {
            return count;
        }
    }
}
