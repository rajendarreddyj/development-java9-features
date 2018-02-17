package com.rajendarreddyj.java9test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * Unit Test for Compare Arrays Equality In Java 9 https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-boolean:A-int-int-boolean:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-byte:A-int-int-byte:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-char:A-int-int-char:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-double:A-int-int-double:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-float:A-int-int-float:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-int:A-int-int-int:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-long:A-int-int-long:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-short:A-int-int-short:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-java.lang.Object:A-int-int-java.lang.Object:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-java.lang.Object:A-java.lang.Object:A-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#equals-T:A-int-int-T:A-int-int-java.util.Comparator-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#compare-int:A-int:A-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#compare-boolean:A-int-int-boolean:A-int-int-
 * https://docs.oracle.com/javase/9/docs/api/java/util/Arrays.html#mismatch-boolean:A-boolean:A-
 * 
 * @author rajendarreddy.jagapathi
 */
public class Java9ArraysEqualsTest {

    /*
    Compare Arrays Equality In Java 9
    public static boolean equals(int[] a, int[] a2)
    public static boolean equals(char[] a, char[] a2)
    public static boolean equals(byte[] a, byte[] a2)
    public static boolean equals(int[] a,
            int aFromIndex,
            int aToIndex,
            int[] b,
            int bFromIndex,
            int bToIndex)
    
    public static boolean equals(char[] a,
            int aFromIndex,
            int aToIndex,
            char[] b,
            int bFromIndex,
            int bToIndex)
    */
    @Test
    public void arrayEqualsTest() {
        int[] existRows = { 0, 1, 2, 3, 4, 5 };
        int[] newRows = { 3, 4, 5, 1, 2, 0 };
        assertFalse(Arrays.equals(existRows, newRows));
        assertTrue(Arrays.equals(existRows, 1, 3, newRows, 3, 5));
        assertTrue(Arrays.equals(existRows, 3, 5, newRows, 0, 2));
    }

    /*
     Compare Arrays Lexicographically In Java 9
     public static int compare(int[] a, int[] b)
     */
    @Test
    public void compareArraysTest() {
        int[] tomMarks = { 5, 6, 7, 8, 9, 10 };
        int[] aliceMarks = { 5, 6, 7, 8, 9, 10 };
        int[] daisyMarks = { 5, 6, 7, 10, 9, 10 };
        int[] maryMarks = { 5, 6, 7, 8 };
        assertEquals(0, Arrays.compare(tomMarks, aliceMarks));
        assertEquals(-1, Arrays.compare(tomMarks, daisyMarks));
        assertEquals(2, Arrays.compare(tomMarks, maryMarks));
    }

    /*
    Compare Arrays Lexicographically In Java 9
    public static int compare(int[] a,
                          int aFromIndex,
                          int aToIndex,
                          int[] b,
                          int bFromIndex,
                          int bToIndex)
    
    public static int compare(long[] a,
                          int aFromIndex,
                          int aToIndex,
                          long[] b,
                          int bFromIndex,
                          int bToIndex)
    */
    @Test
    public void compareSliceArraysTest() {
        int[] tomMarks = { 5, 6, 7, 8, 9, 10 };
        int[] daisyMarks = { 5, 6, 7, 10, 9, 10 };
        int[] maryMarks = { 5, 6, 7, 8 };
        assertEquals(0, Arrays.compare(tomMarks, 0, 3, daisyMarks, 0, 3));
        assertEquals(0, Arrays.compare(tomMarks, 0, 4, maryMarks, 0, maryMarks.length));
        assertEquals(1, Arrays.compare(daisyMarks, 0, 4, maryMarks, 0, maryMarks.length));
    }

    /*
     Finds The Index Of The First Mismatch Between Two Arrays
     mismatch() method finds and returns the index of the first mismatch between two int arrays,
     otherwise return -1 if no mismatch is found.
     The index will be in the range of 0 (inclusive) up to the length (inclusive) of the smaller array.
     public static int mismatch(int[] a, int[] b)
     public static int mismatch(int[] a,
                           int aFromIndex,
                           int aToIndex,
                           int[] b,
                           int bFromIndex,
                           int bToIndex)
    
    ublic static int mismatch(float[] a,
                           int aFromIndex,
                           int aToIndex,
                           float[] b,
                           int bFromIndex,
                           int bToIndex)
     */
    @Test
    public void mismatchArraysTest() {
        int[] a = { 1, 2, 3, 4, 5 };
        int[] b = { 1, 2, 3, 4, 5 };
        int[] c = { 1, 2, 4, 4, 5, 6 };
        assertEquals(-1, Arrays.mismatch(a, b));
        assertEquals(2, Arrays.mismatch(a, c));
        assertEquals(-1, Arrays.mismatch(a, 0, 2, c, 0, 2));
        assertEquals(2, Arrays.mismatch(a, 0, 3, c, 0, 3));
        // mismatch return relative index
        assertEquals(0, Arrays.mismatch(a, 2, a.length, c, 2, 5));
    }
}
