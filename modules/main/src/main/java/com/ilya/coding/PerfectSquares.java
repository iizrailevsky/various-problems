package com.ilya.coding;

/*  Question 4: Perfect Square Sequence Problem
*   Ilya Izrailevsky
*/

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PerfectSquares {

    // set of perfect squares
    private Set<Integer> perfectSquares;

    public PerfectSquares() {
        perfectSquares = new HashSet<Integer>();
        perfectSquares.add(new Integer(4));
        perfectSquares.add(new Integer(9));
        perfectSquares.add(new Integer(16));
        perfectSquares.add(new Integer(25));
        perfectSquares.add(new Integer(36));
        perfectSquares.add(new Integer(49));
        perfectSquares.add(new Integer(64));
        perfectSquares.add(new Integer(81));
        perfectSquares.add(new Integer(100));
        perfectSquares.add(new Integer(121));
        perfectSquares.add(new Integer(144));
    }

    /*
    *   Is the sum a perfect square?
    *
    *   @param a - first number
    *   @param b - second number
    *   @return true is the sum is a perfect square, false otherwise
    */
    private boolean isPerfectSq(Integer a, Integer b) {
        return perfectSquares.contains(new Integer(a.intValue() + b.intValue()));
    }

    /*
    *   Calculate the perfect square sequence if possible.
    *
    *   @param seq - sequence of numbers
    *   @return the perfect square sequence if possible, empty list otherwise
    */
    public List getPerfectSquareSeq(List<Integer> seq) {
        // edge condition
        if (seq == null || seq.isEmpty()) {
            return Collections.emptyList();
        }

        // create the result sequence
        List<Integer> res = new ArrayList<Integer>(seq.size());

        // find the first number and the rest recursively
        for (int i = 0; i < seq.size(); i++) {
            Integer cur = seq.get(i);

            // try using the current
            seq.remove(i);
            res.add(cur);

            // calculate the rest recursively
            calculateNext(cur, seq, res);

            // still numbers left in sequence?
            // try the next number as first instead
            if (!seq.isEmpty()) {
                res.remove(res.size() - 1);
                seq.add(i, cur);
            } else {
                // no numbers left - done
                break;
            }
        }

        if (!seq.isEmpty()) {
            // still numbers left in sequence
            // couldn't calculate the perfect sequence - return empty list
            return Collections.emptyList();
        } else {
            return res;
        }
    }

    /*
    *   Calculate the perfect square sequence if possible.
    *
    *   @param cur - current number
    *   @param seq - the rest of the number sequence
    *   @param res - resulting perfect square number sequence
    */
    private void calculateNext(Integer cur, List<Integer> seq, List<Integer> res) {
        // find the next number recursively
        for (int i = 0; i < seq.size(); i++) {
            Integer next = seq.get(i);

            if (isPerfectSq(cur, next)) {
                // try using the next as current
                seq.remove(i);
                res.add(next);

                // calculate the rest recursively
                calculateNext(next, seq, res);

                // still numbers left in sequence?
                // try the next number as first instead
                if (!seq.isEmpty()) {
                    res.remove(res.size() - 1);
                    seq.add(i, next);
                } else {
                    // no numbers left - done
                    break;
                }
            }
        }
    }

    /*
    *   Print out a given list with a message in front
    *
    *   @param lst - list of numbers
    *   @param message - message
    */
    private static void dumpList(List<Integer> lst, String message) {
        // print them out
        System.out.print(message + " ");
        for (int i = 0; i < lst.size(); i++) {
              System.out.print(lst.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] argv) throws Exception {

        List<Integer> seq = new ArrayList<Integer>();

        // read number sequence
        System.out.print("Enter a number sequence: ");
        String numStrs = (new BufferedReader(new InputStreamReader(System.in))).readLine();
        StringTokenizer st = new StringTokenizer(numStrs);
        while (st.hasMoreTokens()) {
            seq.add(new Integer(st.nextToken()));
        }

        PerfectSquares ps = new PerfectSquares();
        List<Integer> res = ps.getPerfectSquareSeq(seq);
        if (res.isEmpty()) {
            System.out.println("Can't find a perfect square sequence.");
        } else{
            dumpList(res, "Perfect square sequence: ");
        }
    }
}

