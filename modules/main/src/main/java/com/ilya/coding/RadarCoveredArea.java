package com.ilya.coding;

import java.util.*;

/**
 * Created by iizrailevsky on 6/9/18.
 */
public class RadarCoveredArea {
    // Example arguments:
    // l = 100
    // radars = [ [5, 10], [3, 25], [46, 99], [39, 40], [45, 50] ]
    // The `radars` list will consist of lists with two elements
    public static int getCoveredArea(int l, List< List<Integer> > radars) {
        // error checking
        if (l < 0 || radars == null || radars.isEmpty()) {
            return -1;
        }

        int [] area = populateArea(l, radars);
        int totalSum = getTotalCoverage(l, area);
        return totalSum;
    }

    // populate area with radar coverage
    private static int[] populateArea(int l, List< List<Integer> > radars) {
        int[] area = new int[l + 1];
        for (List<Integer> radar : radars) {
            // mark radar starting point as 1
            if (radar.get(0) >= 0 || radar.get(0) <= l) {
                area[radar.get(0)] = 1;
            }
            // mark radar ending point as -1
            if (radar.get(1) >= 0 || radar.get(1) <= l) {
                area[radar.get(1)] = -1;
            }
        }

        return area;
    }

    // calculate total coverage
    private static int getTotalCoverage(int l, int[] area) {
        int start = -1;
        int openCount = 0;
        int totalSum = 0;

        for (int i = 0; i <= l; i++) {
            if (area[i] != 0) {
                if (area[i] == 1) {
                    // increment open count
                    openCount++;
                    // starting open count? record as last open
                    if (openCount == 1) {
                        start = i;
                    }
                } else {
                    // decrement open count
                    openCount--;
                    // if reached end of open count,
                    // calculate coverage and add to total sum
                    if (openCount == 0) {
                        totalSum += i - start;
                    }
                }

            }
        }
        return totalSum;
    }
}
