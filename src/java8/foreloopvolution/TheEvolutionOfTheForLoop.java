package java8.foreloopvolution;

import java.util.Arrays;
import java.util.List;

public class TheEvolutionOfTheForLoop {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("A", "B", "C");
        List<Integer> numbers = Arrays.asList(1,2,3);

        // conventional
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i));
        }
        System.out.println("");

        // java 5
        for (String word : words) {
            System.out.println(word);
        }
        for (Integer number : numbers) {
            System.out.println(number);
        }
        System.out.println("");

        // java 8
        words.forEach(System.out::println);
        numbers.forEach(System.out::println);
    }
}
