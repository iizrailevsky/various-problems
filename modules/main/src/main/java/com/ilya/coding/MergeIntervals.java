package com.ilya.coding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.math.*;


public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        // error checking
        if (intervals == null || intervals.isEmpty()) {
            return null;
        }

        // if just one interval - return it
        if (intervals.size() == 1) {
            // nothing to merge
            return intervals;
        }

        // init variables
        boolean anyMerged = false;
        for (int i = 0; i < intervals.size() && !anyMerged; i++) {
            Interval a = intervals.get(i);
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval b = intervals.get(j);
                if (i != j && isMergable(a, b)) {
                    Interval merged = merge(a, b);
                    // remove merged intervals
                    intervals.remove(a);
                    intervals.remove(b);
                    // add merged
                    intervals.add(0, merged);
                    anyMerged = true;
                    break;
                }
            }
        }

        if (anyMerged) {
            return merge(intervals);
        } else {
            // nothing to merge - done
            return intervals;
        }


    }

    private boolean isMergable(Interval a, Interval b) {
        if (a == null || b == null) {
            return false;
        }

        return b.start <= a.end;
    }

    private Interval merge(Interval a, Interval b) {
        if (a == null || b == null) {
            return null;
        }

        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        System.out.println(mi.merge(intervals));
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
    public String toString() {
        return "[" + start + "," + end + "]";
    }
}