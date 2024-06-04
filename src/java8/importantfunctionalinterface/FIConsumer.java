package java8.importantfunctionalinterface;

import java.util.Arrays;
import java.util.function.Consumer;

public class FIConsumer {
    public static void main(String[] args) {
        Consumer<String> normalPrinter = System.out::println;
        Consumer<String> UpperCasePrinter = s -> System.out.println(s.toUpperCase());
        Consumer<String> normalPrinterThenUpperCasePrinter =
                normalPrinter.andThen(UpperCasePrinter);
        //normalPrinterThenUpperCasePrinter.accept("Hello World");

        //
        Arrays.asList("Hello", "World")
                .stream()
                .forEach(normalPrinterThenUpperCasePrinter);
    }
}
