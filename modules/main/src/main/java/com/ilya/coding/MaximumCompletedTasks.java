package com.ilya.coding;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumCompletedTasks {
    public static int maximumCompletedTasks(int n, int t, List<Integer> task_difficulties) {
        // error checking
        if (n <= 0 || t <= 0 || task_difficulties == null || task_difficulties.isEmpty()) {
            return 0;
        }

        // sort tasks in asc order
        Collections.sort(task_difficulties);

        // init variables
        // sum of time spent
        int sum = task_difficulties.get(0);
        // count of tasks completed
        int count = (sum <= t) ? 1 : 0;

        // calculate tasks difficulties in ascending order
        for (int i = 1; (i < n) && (sum <= t); i++) {
            sum += 2 * task_difficulties.get(i) - task_difficulties.get(i - 1);
            if (sum <= t) {
                count++;
            }
        }

        return count;
    }
}
