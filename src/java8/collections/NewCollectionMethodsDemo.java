package java8.collections;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NewCollectionMethodsDemo {
    public static void main(String[] args) {
        // History
        // previously projects that use this interface
        // no longer work after expansion of Collection methods with other abstract methods
        // therefore java8 Collection interface comes with default implementations

        List<String> words = Arrays.asList("A", "BB", "CCC");
        // words.remove("A"); // UnsupportedOperationException
        words = new ArrayList<>();
        words.add("A");
        words.add("BB");
        words.add("CCC");
//        for (int i = 0; i < words.size(); i++) {
//            String word = words.get(i);
//            System.out.println(word);
//        }
//        for (String word : words) {
//            System.out.println(word);
//        }
        Consumer<String> consumer = string -> System.out.println(string);
        //words.forEach(consumer);
        //words.forEach(word -> System.out.println(word));

        consumer = System.out::println;
        //words.forEach(consumer);
        //words.forEach(System.out::println);

        Predicate<String> stringLengthGreaterThanOne = string -> string.length() > 1;
        words.removeIf(stringLengthGreaterThanOne);
        words.forEach(consumer);

        Set<String> letters = new HashSet<String>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        System.out.println(letters);
        letters.removeIf(letter -> letter.equals("A"));
        System.out.println(letters);

        Map<String, String> translator = new HashMap<>();
        translator.put("Wort", "Word");
        translator.put("Buchstabe", "Letter");
        BiConsumer<String, String> biConsumerForTranslator =
                (key, value) -> System.out.println(key + " in english " + value);
        translator.forEach(biConsumerForTranslator);
        // java 8 streams, but demos later
        Stream<String> wordsAsStream = words.stream();
    }
}
