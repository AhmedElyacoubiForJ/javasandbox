package java8.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamsDemo {
    public static void main(String[] args) {
        int number = 800;
        List<Integer> numbersFrom1To800 = Stream
                .iterate(1, x -> x +1)
                .limit(number)
                .collect(Collectors.toList());
    }
}
