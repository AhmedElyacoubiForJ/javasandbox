package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountDistinctLimitSkipDemo {
    public static void main(String[] args) {
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4);
        // count is terminal
        long numberOfNumbers = myNumbers.stream()
                .count(); // is like myNumbers.size()
        System.out.println(numberOfNumbers);
        System.out.println("");

        List<String> myWords = Arrays.asList("Hello", "Hello", "World", "World", "World");
        // distinct is intermediate
        Stream<String> myUniqueWords = myWords.stream()
               .distinct(); // Hello && World
        myUniqueWords.forEach(System.out::println);
        System.out.println("");

        IntStream from0TillInfinite = IntStream.iterate(0, x -> x + 1);
        // intermediate operation
        IntStream from0To999 = from0TillInfinite.limit(1_000);
        from0To999.forEach(System.out::println);
        System.out.println("");

        // skip is an intermediate operation
        // create a new IntStream because the above one is terminated
        from0TillInfinite = IntStream.iterate(0, x -> x + 1);
        from0To999 = from0TillInfinite.limit(1_000);
        // skip the first 100 elements, means 0 till 99 elements are ignored
        IntStream from100To999 = from0To999.skip(100);
        from100To999.forEach(System.out::println);
        System.out.println("");

        //
        from0TillInfinite = IntStream.iterate(0, x -> x + 1);
        IntStream from1000To1999 = from0TillInfinite.skip(1_000).limit(1_000);
        from1000To1999.forEach(System.out::println);

        // all in one
        long number = IntStream.iterate(0, x -> x + 1)
                .distinct() // no sense, chaining demonstration only
                .limit(100)
                .skip(50)
                .count();
        System.out.println(number); // 50
    }
}
