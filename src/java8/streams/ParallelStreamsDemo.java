package java8.streams;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamsDemo {
    public static void main(String[] args) {
        int number = 800;
        List<Integer> numbersFrom1To800 = Stream
                .iterate(1, x -> x + 1)
                .limit(number)
                .collect(Collectors.toList());

        // the last method call has priority
        //numbersFrom1To800.stream().parallel();
        // from parallel to sequential
        //numbersFrom1To800.stream().parallel().sequential()
        //numbersFrom1To800.stream().parallel().sequential().parallel();
        BiFunction<Integer, Integer, Integer> accumulator = Integer::sum;
        BinaryOperator<Integer> combiner= Integer::sum;
        // parallel processing direct from list
        int sum = numbersFrom1To800.parallelStream()
                .reduce(0, accumulator, combiner);
        System.out.println(sum);

    }
}
