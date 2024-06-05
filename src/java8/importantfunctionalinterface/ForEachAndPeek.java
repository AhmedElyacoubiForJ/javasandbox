package java8.importantfunctionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ForEachAndPeek {
    public static void main(String[] args) {
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> myNumbersAsStream = myNumbers.stream();
        Stream<Integer> myNumbersAsStreamAfterPeek =
                myNumbersAsStream.peek(x -> System.out.println("peek " + x));
        myNumbersAsStreamAfterPeek.forEach(i -> System.out.println("forEach " + i));

        /*Stream.of("one", "two", "three", "four")
                .filter(e -> e. length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System. out. println("Mapped value: " + e))
                .collect(Collectors.toList())
                .forEach(System.out::println);*/
    }
}
