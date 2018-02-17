package com.rajendarreddyj.java9test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
 * Unit Test for New methods in Optional https://docs.oracle.com/javase/9/docs/api/java/util/Optional.html
 * 
 * @author rajendarreddy.jagapathi
 */
public class Java9OptionalNewMethodsTest {

    /*
    public void ifPresentOrElse​(Consumer<? super T> action,
            Runnable emptyAction)
    If a value is present, performs the given action with the value, otherwise performs the given empty-based action.
    Parameters:
    action - the action to be performed, if a value is present
    emptyAction - the empty-based action to be performed, if no value is present
    Throws:
    NullPointerException - if a value is present and the given action is null, or no value is present and the given empty-based action is null.
    */
    @Test
    public void testOptionalIfPresentOrElse() {
        List<Optional<String>> days = List.of(Optional.of("Monday"), Optional.of("Tuesday"), Optional.empty(), Optional.ofNullable(null), Optional.of("Friday"),
                Optional.of("Saturday"), Optional.of("Sunday"));
        days.stream().forEach(p -> p.ifPresentOrElse(System.out::println, () -> System.out.println("Day not available")));
    }

    /*
    public Optional<T> or​(Supplier<? extends Optional<? extends T>> supplier)
    If a value is present, returns an Optional describing the value, otherwise returns an Optional produced by the supplying function.
    Parameters:
    supplier - the supplying function that produces an Optional to be returned
    Returns:
    returns an Optional describing the value of this Optional, if a value is present, otherwise an Optional produced by the supplying function.
    Throws:
    NullPointerException - if the supplying function is null or produces a null result
    */
    @Test
    public void testOptionalOr() {
        List<Optional<Integer>> studentAges = List.of(Optional.of(20), Optional.of(21), Optional.empty(), Optional.ofNullable(null), Optional.of(22),
                Optional.of(18), Optional.of(19));
        studentAges.stream().map(p -> p.or(() -> Optional.of(20))).forEach(System.out::println);
    }

    /*
    public Stream<T> stream​()
    If a value is present, returns a sequential Stream containing only that value, otherwise returns an empty Stream.
    API Note:
    This method can be used to transform a Stream of optional elements to a Stream of present value elements:
         Stream<Optional<T>> os = ..
         Stream<T> s = os.flatMap(Optional::stream)
    Returns:
    the optional value as a Stream
    */
    @Test
    public void testOptionalStream() {
        Optional<String> maleOpt = Optional.of("Male");
        Optional<String> feMaleOpt = Optional.of("FeMale");
        Optional<String> OtherOpt = Optional.empty();
        assertEquals("Male", maleOpt.stream().findFirst().get());
        assertEquals("FeMale", feMaleOpt.stream().findFirst().get());
        assertTrue(maleOpt.stream().count() == 1);
        assertTrue(OtherOpt.stream().count() == 0);
    }
}
