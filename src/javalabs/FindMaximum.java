package javalabs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Write a method that returns the largest integer in the list.
* */
public class FindMaximum {
    public static void main(String[] args) {
        Integer[] numbers = {5, 3, 8, 2, 1, 9, 7};
        Integer max = findMax(numbers);
        System.out.println("The maximum number is: " + max);

        // empty array
        Integer[] emptyArray = {};
        try {
            findMax(emptyArray);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // null array
        try {
            findMax(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // array with single element
        Integer[] singleElementArray = {1};
        Integer maxSingleElementArray = findMax(singleElementArray);
        System.out.println("The maximum number in an array with a single element is: " + maxSingleElementArray);

        // array with duplicate maximum element
        Integer[] duplicateMaxElementArray = {5, 3, 8, 2, 1, 9, 7, 5};
        Integer maxDuplicateMaxElementArray = findMax(duplicateMaxElementArray);
        System.out.println("The maximum number in an array with duplicate maximum element is: " + maxDuplicateMaxElementArray);

        // Solution using Java 8 Streams
        Integer maxUsingStreams = findMaxUsingStreams(numbers);
        System.out.println("The maximum number using streams is: " + maxUsingStreams);

        // with single element
        Integer[] singleElementArrayUsingStreams = {1};
        Integer maxSingleElementArrayUsingStreams = findMaxUsingStreams(singleElementArrayUsingStreams);
        System.out.println("The maximum number in an array with a single element using streams is: " + maxSingleElementArrayUsingStreams);

        // with duplicate maximum element
        Integer[] duplicateMaxElementArrayUsingStreams = {5, 3, 8, 2, 1, 9, 7, 5};
        Integer maxDuplicateMaxElementArrayUsingStreams = findMaxUsingStreams(duplicateMaxElementArrayUsingStreams);
        System.out.println("The maximum number in an array with duplicate maximum element using streams is: " + maxDuplicateMaxElementArrayUsingStreams);
    }

    private static Integer findMax(Integer[] list) {
        if (list == null || list.length == 0) {
            throw new IllegalArgumentException("List must not be null or empty");
        }

        Integer result = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] > result) {
                result = list[i];
            }
        }
        return result;
    }

    // Solution using Java 8 Streams
    public static Integer findMaxUsingStreams(Integer[] list) {
        if (list == null || list.length == 0) {
            throw new IllegalArgumentException("List must not be null or empty");
        }

        return Arrays.stream(list)
                .max(Integer::compareTo)
                .get();
    }
}
