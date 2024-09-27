package javalabs;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        double n = 1;
        double factorialRecursive = factorialRecursive(n);
        System.out.println("FactorialRecursive of " + n + " is: " + factorialRecursive);

        double factorialForLoop = factorialForLoop(n);
        System.out.println("FactorialForLoop of " + n + " is: " + factorialForLoop);

        BigInteger bigInteger = BigInteger.valueOf(1);
        BigInteger bigFactorial = factorialWithBigInteger(bigInteger);
        System.out.println("FactorialWithBigInteger of " + bigInteger + " is: " + bigFactorial);
    }

    private static double factorialRecursive(double number) {
        if (number == 0 || number == 1) return 1d;
        return number * factorialRecursive(number - 1);
    }

    private static double factorialForLoop(double n) {
        double factorial = 1d;
        for (double i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    // factorial BigInteger
    private static BigInteger factorialWithBigInteger(BigInteger n) {
        BigInteger factorial = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            factorial = factorial.multiply(i);
        }
        return factorial;
    }
}