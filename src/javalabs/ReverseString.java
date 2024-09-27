package javalabs;

public class ReverseString {
    public static void main(String[] args) {
//        String input = "java interview";
//        System.out.println("Original String: " + input);
//        System.out.println("Reversed String: " + reverseUsingCharArray(input));

        performanceTestsForAllMethods();

        //testReverseUsingCharArrayPass();
        //testReverseUsingCharArrayFailed();
    }

    private static String reverseUsingCharArray(String input) {
        char[] inputCharArray = input.toCharArray();
        char[] output = new char[input.length()];

        for (int i = inputCharArray.length - 1, j = 0; i >= 0; i--, j++) {
            output[j] = inputCharArray[i];
        }
        return new String(output);
    }

    private static String reverseUsingStringBuilder(String input) {
        StringBuilder reversed = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
        // return new StringBuilder(input).reverse().toString();
        return reversed.toString();
    }

    public static void testReverseUsingCharArrayPass() {
        // large text
        String input = "java interview";
        String reversed = reverseUsingCharArray(input);
        assert reversed.equals("weivretni avaj") : "Test failed";
        System.out.println("Test passed");
    }

    public static void testReverseUsingCharArrayFailed() {
        String input = "java interview";

        String reversed = reverseUsingCharArray(input);
        assert reversed.equals("weivretni java") : "Test failed";
        System.out.println("Test failed");
    }

    public static void performanceTestsForAllMethods() {
        String in = " java interview";
        StringBuilder input = new StringBuilder();
        for (int i = 0; i<=1000000; i++)  {
            input.append(in);
        }

        long startTime, endTime;

        startTime = System.currentTimeMillis();
        reverseUsingCharArray(input.toString());
        endTime = System.currentTimeMillis();
        System.out.println("Using char array: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        reverseUsingStringBuilder(input.toString());
        endTime = System.currentTimeMillis();
        System.out.println("Using StringBuilder: " + (endTime - startTime) + " ms");
    }
}
