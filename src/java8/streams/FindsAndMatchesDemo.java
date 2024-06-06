package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindsAndMatchesDemo {
    public static void main(String[] args) {
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Optional<Integer> firstNumber = myNumbers.stream().findAny();
        //System.out.println(firstNumber.get());
        Optional<Integer> anyNumber = myNumbers.stream().findAny();
        //System.out.println(anyNumber.get());

        firstNumber = myNumbers.parallelStream().findFirst();
        //System.out.println(firstNumber.get());

        // depends on system, but the same system comes always the same result
        anyNumber = myNumbers.parallelStream().findAny();
        //System.out.println(anyNumber.get());

        // matcher
        boolean allGreaterThanFive = myNumbers.stream().allMatch(x -> x > 5);
        //System.out.println(allGreaterThanFive);

        boolean anyGreaterThanFive = myNumbers.stream().anyMatch(x -> x > 5);
        System.out.println(anyGreaterThanFive);

        boolean noneGreaterThanFive = myNumbers.stream().noneMatch(x -> x > 5);
        System.out.println(noneGreaterThanFive);
    }
}
