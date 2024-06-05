package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.IntStream.empty;

// reduce method takes all the values of a list
// and create one result from them, means one value
// Example: many integers to one integer
public class StreamsReduceDemo {
    public static void main(String[] args) {
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4);
        int sumTotal = myNumbers.stream()
                // a gets the first element value of the list
                // after that it serves as accumulator of the operation result, here is the sum.
                // a.s.o.
                .reduce((a, b) -> a + b)// Integer::sum
                .get();
        System.out.println(sumTotal);
        System.out.println("");

        int max = myNumbers.stream()
                // a gets the first element value of the list
                // after that it serves as accumulator of the operation result, here is the max.
                // a.s.o.
                .reduce((a, b) -> Math.max(a, b))// Math::max
                .get();
        System.out.println(max);

        int sumOrZero = myNumbers.stream()
                .reduce(0, Integer::sum); // (a, b) -> a + b;
        System.out.println(sumOrZero);

        // royal method
        int sumOrZeroParallelExecutable = myNumbers.stream()
                //.parallel() // example in separate demos
                .reduce(0, Integer::sum, Integer::sum); // (a, b) -> a + b;
        System.out.println(sumOrZeroParallelExecutable);
        System.out.println("");

        List<PersonDemo> people = Arrays.asList(
                new PersonDemo(10),
                new PersonDemo(15),
                new PersonDemo(20)
        );
        int sumOfAssets = people.stream()
                .reduce(
                        // U is integer, 0 let java know that we want to get an integer
                        // and that applies to outputs of the used functions
                        0,
                        // U, T, U : accumulator is an <Integer> BiFunction<Integer, Person>
                        // T is the type of the stream object.
                        // the accumulator look like a mapping process
                        (sum, person) -> sum + person.assets,
                        // U, U, U : combiner is an <Integer> BinaryFunction <Integer, Integer>
                        (a, b) -> a + b
                );
        System.out.println(sumOfAssets);

        // second approach, but cannot be used in parallel processing
        // one process that takes over the sum operation
        sumOfAssets = people.stream()
                .map(person -> person.assets)
                .reduce(0, (a, b) -> a+b); // Integer::sum
        System.out.println(sumOfAssets);
    }
}

class PersonDemo {
    int assets;

    PersonDemo(int assets) {
        this.assets = assets;
    }
}
