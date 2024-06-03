package java8.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        Consumer<String> myConsumer = (string) -> System.out.println(string);
        // one input no output, println is like accept method from the consumer interface
        myConsumer = System.out::println;

        Supplier<Double> mySupplier = () -> Math.random();
        // no input, one output, random is like get method from the supplier interface
        mySupplier = Math::random;

        BinaryOperator<Integer> myBinaryOperator = (a, b) -> Integer.max(a, b);
        myBinaryOperator = Integer::max;

        Function<String, Integer> myFunction = string -> string.length();
        // string object is the input, object.length is the output
        myFunction = String::length;

        BinaryOperator<String> myBinaryOperator2 = (s1, s2) -> s1.concat(s2);
        myBinaryOperator2 = String::concat;
        //System.out.println(myBinaryOperator2.apply("a", "b"));

        Supplier<String> myStrimgSupplier = () -> new String();
        // constructor method reference
        myStrimgSupplier = String::new; // 1

        Function<String, String> myStringFunction = (string) -> new String(string);
        myStringFunction = String::new; // 2
        // 1, 2 :java can imagine what will be used, the constructor with or without arguments

        List<Integer> myNumbers = Arrays.asList(1, 2, 3, 4, 5);
        myNumbers.forEach(System.out::println);

        DoubleStream infiniteRandomNumbers = DoubleStream.generate(Math::random);
        infiniteRandomNumbers.forEach(System.out::println);
    }
}
