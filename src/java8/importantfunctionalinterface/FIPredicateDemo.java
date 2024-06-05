package java8.importantfunctionalinterface;

import java.util.function.Predicate;

public class FIPredicateDemo {
    public static void main(String[] args) {
        Person man = new Person(18, Gender.MALE);
        Person woman = new Person(18, Gender.FEMALE);
        Person boy = new Person(17, Gender.MALE);
        Person girl = new Person(17, Gender.FEMALE);

        Predicate<Person> isOfLegalAge = p -> p.age >= 18;
        System.out.println(isOfLegalAge.test(man));
        System.out.println(isOfLegalAge.test(girl));

        Predicate<Person> isMale = p -> p.gender == Gender.MALE;
        System.out.println(isMale.test(man));
        System.out.println(isMale.test(woman));

        Predicate<Person> isManAndOfLegalAge = isMale.and(isOfLegalAge);
        // It works too, but it's ugly. the above one is better readable
        // Predicate<Person> isManAndOfLegalAge2 = ((Predicate<Person>)p -> p.age >= 18).and(p -> p.gender == Gender.MALE);
        System.out.println(isManAndOfLegalAge.test(man));
        System.out.println(isManAndOfLegalAge.test(boy));

        Predicate<Person> isManOrOfLegalAge = isMale.or(isOfLegalAge);
        System.out.println(isManOrOfLegalAge.test(man));
        System.out.println(isManOrOfLegalAge.test(woman));
        System.out.println(isManOrOfLegalAge.test(girl));

        Predicate<Person> isMinor = isOfLegalAge.negate();
        System.out.println(isMinor.test(woman));
        System.out.println(isMinor.test(girl));

    }
}

enum Gender {
    MALE, FEMALE;
}
class Person {
    int age;
    Gender gender;
    public Person(int age, Gender gender) {
        this.age = age;
        this.gender = gender;
    }
}
