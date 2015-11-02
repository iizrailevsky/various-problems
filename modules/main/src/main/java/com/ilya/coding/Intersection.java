package com.ilya.coding;

import java.util.*;


public class Intersection {

    public static Set<Object> getIntersection(Set<Object> a, Set<Object> b) {
        /*
          Please implement this method to
          return a Set equal to the intersection of the parameter Sets
          The method should not chage the content of the parameters.
         */
         Set<Object> result = new HashSet<Object>();
         for (Object o : a) {
         	if (b.contains(o)) {
         		result.add(o);
         	}
         }
         return result;

    }
}
