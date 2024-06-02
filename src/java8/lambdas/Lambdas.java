package java8.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Lambdas {
    public static void main(String[] args) {
        Comparator<String> comparatorAnonymousInnerClass = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };

        Comparator<String> comparatorLambda = (String s1, String s2) -> { return s1.length() - s2.length(); };
        comparatorLambda = (s1, s2) -> { return s1.length() - s2.length(); };
        comparatorLambda = (s1, s2) -> s1.length() - s2.length();

        // init & print list
        List<String> words = Arrays.asList("aa", "a", "aaaa", "aaa");
        System.out.println(words);

        // sort & print list
        Collections.sort(words, comparatorAnonymousInnerClass);
        System.out.println(words);

        // reset & print list
        words = Arrays.asList("aa", "a", "aaaa", "aaa");
        System.out.println(words);

        // sort & print list
        Collections.sort(words, comparatorLambda);
        System.out.println(words);

        Predicate<String> wordLengthGreaterThanFiveLetters = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 5;
            };
        };
        wordLengthGreaterThanFiveLetters = (String s) -> s.length() > 5;
        wordLengthGreaterThanFiveLetters = s -> s.length() > 5;

        System.out.println(wordLengthGreaterThanFiveLetters.test("Hello"));
        System.out.println(wordLengthGreaterThanFiveLetters.test("Hello World!"));

        Runnable runnable = () -> System.out.println("Run...");
        runnable.run();
    }
}
