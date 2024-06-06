package java8.importantfunctionalinterface;

import java.time.*;
import java.util.*;
import java.util.function.*;

public class FiBiFunctionAndBinaryOperator {
    public static void main(String[] args) {
        BiFunction<LocalDate, LocalTime, LocalDateTime> biFunction = (date, time) -> LocalDateTime.of(date, time);
        Function<LocalDateTime, String> function = LocalDateTime::toString;
        BiFunction<LocalDate, LocalTime, String> coupled = biFunction.andThen(function);

        String applied = coupled.apply(
                LocalDate.of(2014, 1, 1),
                LocalTime.of(12, 0, 0)
        );
        System.out.println(applied);
        // is nothing more than a BiFunction but input and output have the same type
        // BinaryOperator has no abstract method,
        // but it's inherited from the BiFunction
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);

        BinaryOperator<String> findShortest = BinaryOperator.minBy(
                Comparator.comparingInt(String::length) // (s1, s2) -> s1.length - s2.length;
        );
        String shortest = findShortest.apply("A", "AA");
        System.out.println(shortest);
        //
        BinaryOperator<String> findLongest = BinaryOperator.maxBy(
                Comparator.comparingInt(String::length) // (s1, s2) -> s1.length - s2.length;
        );
        String longest = findLongest.apply("A", "AA");
        System.out.println(longest);

        List<String> words = Arrays.asList("A", "AA", "AAA");
        // 1. approach
        String longestWord = words.stream()
                .reduce(findLongest)
                .get();
        System.out.println(longestWord);
        // 2. approach
        words.stream()
                .reduce(findLongest)
                .ifPresent(System.out::println);

    }
}
