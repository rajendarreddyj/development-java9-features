package com.rajendarreddyj.java9test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * Unit test for Create Immutable Lists In Java 9 By Static Factory Methods
 * https://docs.oracle.com/javase/9/docs/api/java/util/List.html#of-E...-
 * 
 * @author rajendarreddy.jagapathi
 */
public class Java9ImmutableListTest {
    /*
     *  Syntax
     *  List.of()
     *  List.of(e1)
     *  List.of(e1, e2)         // fixed-argument form overloads up to 10 elements
     *  List.of(elements...)   // varargs form supports an arbitrary number of elements or an array
     */

    @Test
    public void testImmutableCollections() {
        List<String> fruits = List.of("Mangosteen", "Durian fruit", "Longan");
        assertThrows(UnsupportedOperationException.class, () -> {
            fruits.add("Mango");
            fruits.remove(1);
        });
        assertEquals(3, fruits.size());

    }

    @Test
    public void testImmutableListNotModified() {
        List<String> cerealMix = List.of("Papaya", "Raisin", "Dried Apple", "Dried Peach");
        assertEquals(4, cerealMix.size());
        assertThrows(UnsupportedOperationException.class, () -> {
            // Add more element
            cerealMix.add("Wheat");
            // Remove element
            cerealMix.remove(1);
        });
    }

    @Test
    public void testImmutableListMutableElements() {
        Map<Integer, String> numbersMap = new HashMap<>();
        numbersMap.put(1, "One");
        numbersMap.put(2, "Two");
        Map<Integer, String> currencyMap = new HashMap<>();
        currencyMap.put(100, "Hundreds");
        currencyMap.put(1000, "Thousands");
        List<Map<Integer, String>> numCurrList = List.of(numbersMap, currencyMap);
        assertEquals(2, numCurrList.get(0).size());
        // Add more elements to the mutable element of the List
        numbersMap.put(3, "Three");
        numCurrList.get(0).put(4, "Four");
        assertEquals(4, numCurrList.get(0).size());
    }

    @Test
    public void testImmutableListNullAttempts() {
        assertThrows(NullPointerException.class, () -> {
            List.of(null, null);
        });
    }

    @Test
    public void testImmutableListOrdered() {
        List<?> coffeeList = List.of("Espresso", "Latte", "Cappuccino");
        assertEquals("Espresso", coffeeList.get(0));
        assertEquals(2, coffeeList.indexOf("Cappuccino"));
    }

    @Test
    public void testImmutableListSerializable() throws IOException {
        List<String> drinks = List.of("Coffee", "Wine", "Fruit");
        // serialize the list
        ObjectOutputStream oos = new ObjectOutputStream(System.out);
        oos.writeObject(drinks);
        // create a list of non-serializable objects
        List<OutputStream> outputStreamList = List.of(new ByteArrayOutputStream(), new PrintStream(System.out));
        assertThrows(NotSerializableException.class, () -> {
            oos.writeObject(outputStreamList);
        });
    }

}
