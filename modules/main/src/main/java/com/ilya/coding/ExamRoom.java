package com.ilya.coding;

import java.util.*;

public class ExamRoom {

    private TreeSet<Integer> seats;
    private int N;

    public ExamRoom(int N) {
        if (N <= 0) throw new IllegalArgumentException("Invalid N!");
        this.N = N;
        this.seats = new TreeSet();
    }

    private int addSeat(int seat) {
        seats.add(seat);
        return seat;
    }

    /**
     * Allocates the next best seat that maximizes the distance to the closest person
     * @return seat allocated between 0 and N-1
     */
    public int seat() {
        // no seats allocated?
        if (seats.isEmpty()) {
            return addSeat(0);
        }

        // find best seat
        int maxClosestDist = Integer.MIN_VALUE;
        int selectedSeat = -1;
        Iterator<Integer> iter = seats.iterator();
        int prev = iter.next();

        // 0 not allocated? try it
        if (prev != 0) {
            int cur = prev;
            int seat = 0;
            int closestDist = Math.abs(cur - seat);
            if (closestDist > maxClosestDist) {
                maxClosestDist = closestDist;
                selectedSeat = seat;
            }
        }

        while (iter.hasNext()) {
            int cur = iter.next();
            int seat = (prev + cur) / 2;
            int closestDist = Math.min(Math.abs(seat - prev), Math.abs(cur - seat));
            if (closestDist > maxClosestDist) {
                maxClosestDist = closestDist;
                selectedSeat = seat;
            }
            prev = cur;
        }

        // N - 1 not allocated? try it
        if (seats.last() != N - 1) {
            int cur = seats.last();
            int seat = N - 1;
            int closestDist = Math.abs(seat - cur);
            if (closestDist > maxClosestDist) {
                maxClosestDist = closestDist;
                selectedSeat = seat;
            }
        }
        return addSeat(selectedSeat);
    }

    /**
     * Removes student from seat
     * @param p
     */
    public void leave(int p) {
        if (seats.contains(p)) {
            seats.remove(p);
        }
    }
}
