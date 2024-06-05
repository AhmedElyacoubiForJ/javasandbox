package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamMapDemo {
    public static void main(String[] args) {
        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4);

        Stream<Integer> myNumbersTimesTwoAsStream = myNumbers.stream()
                .map(n -> n * 2);
        myNumbersTimesTwoAsStream.forEach(System.out::println);
        System.out.println("");

        Stream<Double> myNumbersTimesTwoAsStreamDouble = myNumbers.stream()
                .map(n -> n * 2.); // . is for double
        myNumbersTimesTwoAsStreamDouble.forEach(System.out::println);
        System.out.println("");

        // map to int
        IntStream myNumbersTimesTwoAsIntStream = myNumbers.stream()
                .mapToInt(x -> x * 2);
        myNumbersTimesTwoAsIntStream.forEach(System.out::println);
        System.out.println("");

        // map to double
        DoubleStream myNumbersTimesTwoAsDoubleStream = myNumbers.stream()
                .mapToDouble(x -> x * 2.); // . is for double
        myNumbersTimesTwoAsDoubleStream.forEach(System.out::println);
        System.out.println("");

        // map to long
        LongStream myNumbersTimesTwoAsLongStream = myNumbers.stream()
                .mapToLong(x -> x * 2L); // L is for double
        myNumbersTimesTwoAsLongStream.forEach(System.out::println);
        System.out.println("");

        Stream<Person> people = Stream.of(
                new Person("Markus"),
                new Person("Anne"),
                new Person("Marie")
        );
        Stream<String> names = people.map(person -> person.name);
        names.forEach(System.out::println);
        System.out.println("");

        Stream.of(new Person("Markus"), new Person("Anne"), new Person("Marie"))
                .map(person -> person.name)
                .forEach(System.out::println);
    }
}
class Person {
    String name;
    public Person(String name) { this.name = name;}
}
