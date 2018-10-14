package com.ilya.coding;

import java.util.*;

public class Heaters {

    public static int findRadius(int[] houses, int[] heaters) {
        // error checking
        if (houses == null || houses.length == 0 || heaters == null || heaters.length == 0) {
            return -1;
        }

        int maxDistance = 0;
        int i = 0;
        // sort the houses and heaters
        Arrays.sort(houses);
        Arrays.sort(heaters);

        // find the closest heater for each house and max distance
        for (int house : houses) {
            // find the closest heater - go until next heater is farther away
            while (i < heaters.length - 1 && Math.abs(heaters[i + 1] - house) <= Math.abs(heaters[i] - house)) {
                i++;
            }
            maxDistance = Math.max(maxDistance, Math.abs(heaters[i] - house));
        }

        return maxDistance;
    }
}
