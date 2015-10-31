package com.ilya.coding;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class FibonacciTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FibonacciTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( FibonacciTest.class );
    }

    /**
     * Iterative Fibonacci
     */
    public void testApp()
    {
        Fibonacci app = new Fibonacci();
        assertEquals(1, app.getNthFibonacci(1));
        assertEquals(1, app.getNthFibonacci(2));
        assertEquals(2, app.getNthFibonacci(3));
        assertEquals(3, app.getNthFibonacci(4));
        assertEquals(5, app.getNthFibonacci(5));
        assertEquals(8, app.getNthFibonacci(6));
        assertEquals(13, app.getNthFibonacci(7));
        assertEquals(21, app.getNthFibonacci(8));
        assertEquals(34, app.getNthFibonacci(9));
        assertEquals(55, app.getNthFibonacci(10));
    }

    /**
     * Recursive Fibonacci
     */
    public void testFibonacciRec()
    {
        Fibonacci app = new Fibonacci();
        assertEquals(1, app.getNthFibonacciRec(1));
        assertEquals(1, app.getNthFibonacciRec(2));
        assertEquals(2, app.getNthFibonacciRec(3));
        assertEquals(3, app.getNthFibonacciRec(4));
        assertEquals(5, app.getNthFibonacciRec(5));
        assertEquals(8, app.getNthFibonacciRec(6));
        assertEquals(13, app.getNthFibonacciRec(7));
        assertEquals(21, app.getNthFibonacciRec(8));
        assertEquals(34, app.getNthFibonacciRec(9));
        assertEquals(55, app.getNthFibonacciRec(10));
    }

    /**
     * Dynamic programming Fibonacci
     */
    public void testFibonacciDP()
    {
        Fibonacci app = new Fibonacci();
        assertEquals(1, app.getNthFibonacciDP(1));
        assertEquals(1, app.getNthFibonacciDP(2));
        assertEquals(2, app.getNthFibonacciDP(3));
        assertEquals(3, app.getNthFibonacciDP(4));
        assertEquals(5, app.getNthFibonacciDP(5));
        assertEquals(8, app.getNthFibonacciDP(6));
        assertEquals(13, app.getNthFibonacciDP(7));
        assertEquals(21, app.getNthFibonacciDP(8));
        assertEquals(34, app.getNthFibonacciDP(9));
        assertEquals(55, app.getNthFibonacciDP(10));
    }
}

