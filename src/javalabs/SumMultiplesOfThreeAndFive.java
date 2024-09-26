package javalabs;

/*
 * Given a number n, write a method that sums all multiples of three and five up to n (inclusive).
 *
 * The method 'sum' takes an integer 'n' as input and initializes a variable 'sum' to 0.
 * It then iterates through numbers from 1 to 'n' (exclusive) using a for loop.
 * For each number, it checks if it is divisible by either 3 or 5 using the modulo operator (%).
 * If the number is divisible by 3 or 5, it adds the number to the 'sum' variable.
 * Finally, the method returns the 'sum' value.
 *
 * In the main method, an example usage is shown where the sum of multiples of 3 and 5 up to 1000 is printed.
 *
 */
public class SumMultiplesOfThreeAndFive {
    public static void main(String[] args) {

        Integer n = 1000;
        System.out.println("The sum of multiples of 3 and 5 below " + n + " is " + sum(1000));
    }

    private static Integer sum(Integer n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
