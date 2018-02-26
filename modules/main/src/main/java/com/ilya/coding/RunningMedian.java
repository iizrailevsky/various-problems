package com.ilya.coding;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedian {

    // max heap
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, Collections.reverseOrder());
    // min heap
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(11);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            // add value to list
            addToList(a[a_i]);
            //DecimalFormat df = new DecimalFormat("###.#");
            System.out.println(getMedian());
        }
    }

    // add to the list (max + min heaps combo)
    private static void addToList(int value) {
        // error checking
        if (value < 0) {
            return;
        }

        // max heap empty or value < top of max heap - add new value to max heap
        if (maxHeap.size() == 0 || value < maxHeap.peek()) {
            maxHeap.add(value);
        } else {
            // new value is greater than top of max heap - add it to min heap instead
            minHeap.add(value);
        }

        // rebalance the heaps if needed
        rebalanceHeaps();
    }

    // rebalances the max and min heaps if needed
    private static void rebalanceHeaps() {
        int heapSizeDiff = Math.abs(maxHeap.size() - minHeap.size());
        // if heap sizes are the same or off by 1, then balanced already
        if (heapSizeDiff == 0 || heapSizeDiff == 1) {
            return;
        } else if (maxHeap.size() - minHeap.size() > 1) {
            // if max heap has > 1 elements than min heap
            // then remove top from max heap and add to min heap
            minHeap.add(maxHeap.poll());
            // keep rebalancing
            rebalanceHeaps();
        } else if (minHeap.size() - maxHeap.size() > 1) {
            // opposite situation
            maxHeap.add(minHeap.poll());
            // keep rebalancing
            rebalanceHeaps();
        }
    }

    // returns the median of the list (max + min heaps)
    private static double getMedian() {
        // error checking
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            return -1;
        }
        // rebalance the heaps if needed
        rebalanceHeaps();

        // if both heaps are the same size - then average the top elements
        if (maxHeap.size() == minHeap.size()) {
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        } else if (maxHeap.size() > minHeap.size()) {
            // take max heap's top as median
            return maxHeap.peek();
        } else {
            // take min heap's top as median
            return minHeap.peek();
        }
    }
}
