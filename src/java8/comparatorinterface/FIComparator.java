package java8.comparatorinterface;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Collections.reverseOrder;
import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;

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

        Comparator<String> lengthAscendingComparator = comparing(string -> string.length() );
        myWords.sort(lengthAscendingComparator);
        myWords.sort(comparing(string -> string.length()));
        // sort my words using length of words
        myWords.sort(comparing(String::length));
        //myWords.forEach(System.out::println);

        Comparator<String> lengthDescendingComparator = lengthAscendingComparator.reversed();
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
                    comparing(Person::getName).thenComparing(Person::getAge);
        people.sort(firstNameThenAgeAscendingComparator);
        // print sorted list
        people.forEach(System.out::println);

       /* Comparator<Person> firstNameThenAgeDescendingComparator = firstNameThenAgeAscendingComparator.reversed();
        people.sort(firstNameThenAgeDescendingComparator);
        // print sorted list
        people.forEach(System.out::println);*/





        myLetters = Arrays.asList("B", "A", "C", null);
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
            return "Person{" + "name=" + name  + ", age=" + age + '}';
        }
    }
}

