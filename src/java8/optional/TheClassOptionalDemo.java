package java8.optional;

import java.util.*;
import java.util.function.Supplier;

public class TheClassOptionalDemo {
    public static void main(String[] args) {
       /* // To avoid Null pointer exception
        Optional<String> helloWorldOptionalString = Optional.ofNullable("Hello world!");
        System.out.println(helloWorldOptionalString.get());
        System.out.println(helloWorldOptionalString.isPresent());
        System.out.println(helloWorldOptionalString.isEmpty());
        //System.out.println(helloWorldOptionalString);

        Optional<String> emptyOptionalString = Optional.ofNullable(null);
        try {
            emptyOptionalString.get(); // NoSuchElementException
        } catch (NoSuchElementException e) {
            System.out.println("No element in the optional");
        }
        boolean isPresent = emptyOptionalString.isPresent();
        System.out.println(isPresent);
        boolean IsEmpty = emptyOptionalString.isEmpty();
        System.out.println(IsEmpty);
        try {
            emptyOptionalString = Optional.of(null); // direct a NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Don't create Optional with 'of' method");
        }
        helloWorldOptionalString = Optional.of("hello world!");

        emptyOptionalString = Optional.empty();

        Consumer<String> stringPrinter = string -> System.out.println(string);
        //stringPrinter.accept(helloWorldOptionalString.get());
        helloWorldOptionalString.ifPresent(stringPrinter);
        helloWorldOptionalString.ifPresent(string -> System.out.println(string));
        //helloWorldOptionalString.ifPresent(System.out::println); // method reference

        emptyOptionalString = Optional.empty();
        emptyOptionalString.ifPresentOrElse(
                stringPrinter,
                () -> System.out.println("No element in the optional")
        );
//        helloWorldOptionalString.ifPresentOrElse(
//                System.out::println,
//                () -> System.out.println("No element in the optional")
//        );
        String optionalOrElseMessage = emptyOptionalString.orElse("No element in the optional");
        System.out.println(optionalOrElseMessage);
        optionalOrElseMessage = helloWorldOptionalString.orElse("No element in the optional");
        System.out.println(optionalOrElseMessage);
*/
        Optional<String> emptyOptional = Optional.empty();
        List<String> words = Arrays.asList("one", "two", "three", "four", "five", "six");
        Supplier<String> randomWordSupplier = () -> getRandomValueElement(words);
        System.out.println(emptyOptional.orElseGet(randomWordSupplier));
        // or we direct a supplier
        System.out.println(emptyOptional.orElseGet(() -> getRandomValueElement(words)));
        emptyOptional = Optional.of("Not empty");
        System.out.println(emptyOptional.orElseGet(randomWordSupplier));

        Optional<String> stringPossible = getStringPossibly();
        stringPossible.ifPresent(
                string -> System.out.println(string)
        );
        stringPossible.ifPresentOrElse(
                string -> System.out.println(string),
                () -> System.out.println("Empty optional")
        );


    }

    private static <E> E getRandomValueElement(List<E> list) {
        int listSize = list.size();
        int randomPosition = (int) (Math.random() * listSize);
        return list.get(randomPosition);
    }

    public static Optional<String> getStringPossibly() {
        return Math.random() < 0.5 ? Optional.of("a string") : Optional.empty();
    }

   /* private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }*/
}
