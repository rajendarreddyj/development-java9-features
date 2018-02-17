package com.rajendarreddyj.java9test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Unit Test for Streams API Updates In Java 9 https://docs.oracle.com/javase/9/docs/api/java/util/stream/Stream.html
 * 
 * @author rajendarreddy.jagapathi
 */
public class Java9StreamApiUpdatesTest {

    /*
    default Stream<T> dropWhile(Predicate<? super T> predicate)
    Parameters:
    predicate – a non-interfering, stateless predicate to apply to elements to determine the longest prefix of elements.
    Returns:
    the new stream
     */
    @Test
    public void dropWhileTest() {
        Stream<Integer> stdMarks = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> goodMarks = stdMarks.dropWhile(s -> s < 5);
        goodMarks.forEach(System.out::println);
        System.out.println("--------------------------------");
        /*if a stream is unordered, and some (but not all) elements of this stream match the given predicate,
         * then the behavior of the dropWhile() method is non-deterministic; it is free to drop any subset of
         * matching elements (which includes the empty set). With the current implementation, we can see that
         * the dropWhile() method drops the matching elements from the beginning until it finds a non-matching element.
        */
        Stream<Integer> givenMarks = Stream.of(1, 2, 10, 9, 5, 6, 2, 3);
        Stream<Integer> remainMarks = givenMarks.dropWhile(s -> s < 5);
        remainMarks.forEach(System.out::println);
    }

    /*
    default Stream<T> takeWhile(Predicate<? super T> predicate)
    It returns a stream consisting of a subset of elements taken from a stream that matches the given predicate.
     */
    @Test
    public void takeWhileTest() {
        Stream<Integer> stdMarks = Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> ngMarks = stdMarks.takeWhile(s -> s < 5);
        ngMarks.forEach(System.out::println);
        System.out.println("--------------------------------");
        /*
         * if a stream is unordered, and some (but not all) elements of the stream match the given predicate,
         * then the behavior of this operation is nondeterministic; it is free to take any subset of matching
         * elements (which includes the empty set). With the current implementation, we can see that the
         * takeWhile() method takes the matching elements from the beginning until it finds a non-matching element.
        */
        Stream<Integer> givenMarks = Stream.of(1, 2, 10, 9, 5, 6, 2, 3);
        Stream<Integer> remainMarks = givenMarks.takeWhile(s -> s < 5);
        remainMarks.forEach(System.out::println);
    }

    /*
     static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)
     static <T> Stream<T> iterate(T seed,
                             Predicate<? super T> hasNext,
                             UnaryOperator<T> next)
     The method returns an infinite sequential ordered Stream produced by iterative application
     of a function f to an initial element seed, producing a Stream consisting of seed, f(seed), f(f(seed)), etc.
     */
    @Test
    @Disabled
    public void streamTest() {
        Stream.iterate(0, n -> n + 1).forEach(System.out::println);
        System.out.println("--------------------------------");
        Stream.iterate(0, n -> n < 100, n -> n + 1).forEach(System.out::println);
    }

    /*
    static <T> Stream<T> ofNullable(T t)
    The ofNullable() method returns a sequential Stream containing a single element,
    if non-null, otherwise returns an empty Stream. For example:
     */
    @Test
    public void ofNullableTest() {
        String username = null;
        Stream<String> st = Stream.ofNullable(username);
        assertEquals(0, st.count());
        username = "admin";
        st = Stream.ofNullable(username);
        assertEquals(1, st.count());
    }

}
