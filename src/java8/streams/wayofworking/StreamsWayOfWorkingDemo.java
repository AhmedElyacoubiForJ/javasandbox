package java8.streams.wayofworking;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsWayOfWorkingDemo {
    public static void main(String[] args) {
        System.out.println("Streams Way Of Working Demo");
        List<String> words = Arrays.asList("World", "PC", "Hello", "Day");
        // 1. create a stream
        Stream<String> wordsStream = words.stream();
        // intermediate operations
        Stream<String> wordsStreamSorted = wordsStream.sorted();
        // wordsStream.sorted(); => IllegalStateException means the stream is closed.

        Stream<String> wordsStreamSortedFiltered =
                wordsStreamSorted.filter(string -> string.length() > 3);
        //wordsStreamSortedFiltered.forEach(System.out::println);

        Stream<String> wordsStreamSortedFilteredUpperCase =
                wordsStreamSortedFiltered.map(String::toUpperCase);

        // 3. one terminal operation
        wordsStreamSortedFilteredUpperCase.forEach(System.out::println);

        //
        words.stream()
                .sorted()
                .filter(string -> string.length() > 3)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
