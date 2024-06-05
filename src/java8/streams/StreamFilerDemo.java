package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamFilerDemo {
    public static void main(String[] args) {
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4);
        myNumbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        System.out.println("");

        myNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isGreaterThanFive = n -> n > 5;

        // all even numbers and greater than five
        myNumbers.stream()
                .filter(isEven.and(isGreaterThanFive))
                .forEach(System.out::println);
        // 1, 3, 5 neither even nor greater than five
        System.out.println("");

        // all even numbers or greater than five
        myNumbers.stream()
                .filter(isEven.or(isGreaterThanFive))
                .forEach(System.out::println);

        System.out.println("");

        // negate > all even numbers or greater than five
        // all odd numbers and less than five
        myNumbers.stream()
                .filter(isEven.or(isGreaterThanFive).negate())
                .forEach(System.out::println);

    }
}
