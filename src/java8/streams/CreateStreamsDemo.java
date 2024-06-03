package java8.streams;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamsDemo {
    public static void main(String[] args) {
        System.out.println("Create Streams Demo");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> integerStream = numbers.stream();

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        // creation of streams
        Stream<String> monthsStream = Stream.of(months);
        monthsStream = Arrays.stream(months);

        Stream<String> germanCitiesStream = Stream.of("München", "Düsseldorf", "Essen", "Frankfurt", "Köln");

        //IntStream numbersFrom0Till99 = IntStream.range(0, 100);
        //numbersFrom0Till99.forEach(value -> System.out.println(value));
        //numbersFrom0Till99 = IntStream.iterate(0, x -> x + 1).limit(100);
        //numbersFrom0Till99.forEach(value -> System.out.println(value));

        //DoubleStream randomDoublesStream = DoubleStream.generate(() -> Math.random()).limit(10);
        //randomDoublesStream.forEach(value -> System.out.println(value));

        //IntStream numbersFrom0Till10Exclusive = IntStream.range(0,10);
        //numbersFrom0Till10Exclusive.forEach(value -> System.out.println(value));

        //IntStream numbersFrom0Till10Inclusive = IntStream.rangeClosed(0, 10);
        //numbersFrom0Till10Inclusive.forEach(value -> System.out.println(value));

        //Stream<Integer> emptyIntStream = Stream.empty();

        try {
            Stream<String> fileLines = Files.lines(
                    Paths.get("test.txt"),
                    StandardCharsets.UTF_8
            );
            fileLines.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        IntStream lettersAsIntStream = "Hallo Welt".chars();
        lettersAsIntStream.forEach(value -> System.out.println(value));
        // stream already consumed, initialize new stream
        lettersAsIntStream = "Hallo Welt".chars();
        lettersAsIntStream.forEach(value -> System.out.println((char) value));
    }
}