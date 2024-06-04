package java8.comparatorinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.*;

public class FIComparator {
    public static void main(String[] args) {
        List<String> myLetters = Arrays.asList("B", "A", "C");

        Comparator<String> alphabetical = Comparator.naturalOrder();
        myLetters.sort(alphabetical);
        myLetters.sort(naturalOrder());
        //myLetters.forEach(System.out::println);

        Comparator<String> reverseAlphabetical = Comparator.reverseOrder();
        myLetters.sort(reverseAlphabetical);
        myLetters.sort(reverseOrder());
        //myLetters.forEach(System.out::println);

        List<String> myWords = Arrays.asList("AAA", "BB", "C");

        Comparator<String> lengthAscendingComparator =
                comparing(string -> string.length());
        myWords.sort(lengthAscendingComparator);
        myWords.sort(comparing(string -> string.length()));
        // sort my words using length of words
        myWords.sort(comparing(String::length));
        //myWords.forEach(System.out::println);

        Comparator<String> lengthDescendingComparator =
                lengthAscendingComparator.reversed();
        myWords.sort(lengthDescendingComparator);
        // sort my words using length of words and turn everything around
        myWords.sort(comparing(String::length).reversed());
        //myWords.forEach(System.out::println);

        List<Person> people = Arrays.asList(
                new Person("B", 1),
                new Person("A", 2),
                new Person("A", 1)
        );
        Comparator<Person> firstNameThenAgeAscendingComparator =
                comparing(Person::getName)
                        .thenComparing(Person::getAge);
        people.sort(firstNameThenAgeAscendingComparator);
        //people.forEach(System.out::println);
        people.sort(comparing(Person::getName).thenComparing(Person::getAge));
        // print sorted list
        //people.forEach(System.out::println);

        Comparator<Person> firstNameAscedingThenAgeDescendingComparator =
                comparing(Person::getName)
                        .thenComparing(
                                Comparator.comparing(Person::getAge).reversed()
                        );
        people.sort(firstNameAscedingThenAgeDescendingComparator);
        //people.forEach(System.out::println);
        // variant 1. name ascending and age descending
        people.sort(
                comparing(Person::getName)
                        .thenComparing(
                                Comparator.comparing(Person::getAge).reversed()
                        )
        );
        //people.forEach(System.out::println);
        // variant 2. name ascending and age descending
        people.sort(
                comparing(Person::getName)
                        .thenComparing(
                                Person::getAge,
                                reverseOrder()
                        )
        );
        //people.forEach(System.out::println);

        //
        myLetters = Arrays.asList("B", "A", "C", null);
        Comparator<String> nullsFirstComparator = nullsFirst(naturalOrder());
        myLetters.sort(nullsFirstComparator);
        myLetters.sort(nullsFirst(naturalOrder()));
        // print the sorted list
        //myLetters.forEach(System.out::println);

        // all what we do before is usable for streams also
        // sort name ascending and age descending
        people.stream()
                .sorted(comparing(Person::getName).thenComparing(Person::getAge, reverseOrder()))
                .forEach(System.out::println);
    }


    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" + "name=" + name + ", age=" + age + '}';
        }
    }
}

