package java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamSortedMaxMinDemo {
    public static void main(String[] args) {
        List<String> myLetters = Arrays.asList("one","five","seven","eleven", "thirteen");
//        myLetters.stream()
//                .sorted() // natural order
//                .forEach(System.out::println);

        Comparator<String> comparatorNaturalOrder = (s11, s22) -> s11.length() - s22.length();
        Comparator<String> comparatorNaturalOrderReversed = comparatorNaturalOrder.reversed();
        myLetters.stream()
                .sorted(comparatorNaturalOrder)
                .forEach(System.out::println);
        myLetters.stream()
                .sorted(comparatorNaturalOrderReversed)
                .forEach(System.out::println);

        myLetters.stream()
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);
        myLetters.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .forEach(System.out::println);

        String maxWord = myLetters.stream()
                .max(Comparator.comparing(String::length))
                .get();
        System.out.println("Max word: " + maxWord);

        String minWord = myLetters.stream()
                .min(Comparator.comparing(String::length))
                .get();
        System.out.println("Min word: " + minWord);
    }
}
