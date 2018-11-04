package com.ilya.coding;

import java.util.*;

public class BasicCalculator2 {

    public static int calculate(String s) {
        // error checking
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Invalid input " + s);
        }

        // remove spaces
        s = s.replaceAll("\\s+", "");
        List<String> expr = split(s);
        // 1st multipy / divide
        reduce(expr, true);
        // now add / subtract
        reduce(expr, false);

        if (expr.size() == 1) {
            return Integer.parseInt(expr.get(0));
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private static List<String> split(String s) {
        String[] exprArr = s.split("(?=[/*\\-+])|(?<=[/*\\-+])");
        List<String> expr = new ArrayList();
        for (int i = 0; i < exprArr.length; i++) {
            expr.add(exprArr[i]);
        }
        return expr;
    }

    private static void reduce(List<String> expr, boolean multiplyDivide) {
        for (int i = 0; i < expr.size(); i++) {
            int res = 0;
            boolean found = false;
            if (multiplyDivide) {
                if (expr.get(i).equals("*")) {
                    res = Integer.parseInt(expr.get(i - 1)) * Integer.parseInt(expr.get(i + 1));
                    found = true;
                } else if (expr.get(i).equals("/")) {
                    res = Integer.parseInt(expr.get(i - 1)) / Integer.parseInt(expr.get(i + 1));
                    found = true;
                }
            } else {
                if (expr.get(i).equals("+")) {
                    res = Integer.parseInt(expr.get(i - 1)) + Integer.parseInt(expr.get(i + 1));
                    found = true;
                } else if (expr.get(i).equals("-")) {
                    res = Integer.parseInt(expr.get(i - 1)) - Integer.parseInt(expr.get(i + 1));
                    found = true;
                }
            }

            // found operator?
            if (found) {
                expr.remove(i - 1);
                expr.remove(i - 1);
                expr.remove(i - 1);
                expr.add(i - 1, Integer.toString(res));
                i = i - 1;
            }
        }
    }


}
