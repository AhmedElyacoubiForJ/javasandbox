package java8.importantfunctionalinterface;

import java.util.Comparator;
import java.util.function.*;

public class ImportantFunctionalInterfacesDemo {
    public static void main(String[] args) {
        // old
        Runnable runnable = () -> System.out.println("Run...");

        Comparator<A> comparatorA = (A a1, A a2) -> a1.aInt - a2.aInt;
        Comparator<String> comparatorString = (String s1, String s2) -> s1.length() - s2.length();

        // new
        Function<A, B> functionAB = (A oneA) -> B.oneB;
        Function<String, Integer> functionStringInteger = (String string) -> string.length();

        Predicate<A> predicateA = (A oneA) -> true;
        Predicate<String> predicateString = (String string) -> string.isEmpty();

        Supplier<A> supplierA = () -> A.oneA;
        Supplier<Double> supplierDouble = () -> Math.random();

        Consumer<A> consumerA = (A oneA) -> doSomethingWith(oneA);
        Consumer<String> consumerString = (String string) -> System.out.println(string);

        BiFunction<A, B, C> biFunctionABC = (A oneA, B oneB) -> C.oneC;
        BiFunction<String, Font, Integer> biFunction = (String string, Font font) -> string.length() * font.size;

        // special case of BiFunction A, B, C > A, A, A
        BinaryOperator<A> binaryOperatorA = (A a1, A a2) -> A.oneA;
        BinaryOperator<String> binaryOperatorString = (String s1, String s2) -> s1.length() > s2.length()? s1 : s2;
        BinaryOperator<Font> binaryOperatorFont = (Font f1, Font f2) -> f1.size > f2.size? f1 : f2;
        BinaryOperator<Integer> binaryOperatorInteger = (Integer i1, Integer i2) -> i1 + i2;

    }
    public static void doSomethingWith(A oneA) {}
}

class A {static A oneA; int aInt;}
class B {static B oneB;}
class C {static C oneC;}
class Font {int size;}
