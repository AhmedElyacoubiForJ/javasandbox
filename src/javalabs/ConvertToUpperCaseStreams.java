package javalabs;

import java.util.List;
import java.util.stream.Collectors;

/*
 * Write a method that converts all strings in a list to their upper case.
 * */
public class ConvertToUpperCaseStreams {
    public static void main(String[] args) {
        List<String> lines = List.of(
                "hello",
                "world",
                "java"
        );

        // Output: [HELLO, WORLD, JAVA]
        System.out.println(convertToUpperCase(lines));
    }

    // Using Java 8 Stream API
    public static List<String> convertToUpperCase(List<String> lines) {
        return lines.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
