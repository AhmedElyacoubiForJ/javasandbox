package java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCollectDemo {
    public static void main(String[] args) {
        List<PersonToCollect> people = Arrays.asList(
                new PersonToCollect("A", "JavaCity", 1),
                new PersonToCollect("B", "JavaCity", 2),
                new PersonToCollect("C", "JavaVillage", 3),
                new PersonToCollect("D", "JavaVillage", 4),
                new PersonToCollect("E", "JavaCity", 5)

        );
        List<String> myWords = Arrays.asList("one", "two", "three", "four", "five", "six", "seven");

        List<PersonToCollect> peopleAgeGreaterThanThreeYears = people.stream()
                .filter(p -> p.getAge() > 3).toList();
        peopleAgeGreaterThanThreeYears.forEach(System.out::println);
        System.out.println("");

        peopleAgeGreaterThanThreeYears = people.stream()
                .filter(p -> p.getAge() > 3)
                .collect(Collectors.toList());
        peopleAgeGreaterThanThreeYears.forEach(System.out::println);
        System.out.println("");

        Map<Integer, List<String>> wordsGroupedByLength = myWords.stream()
                .collect(Collectors.groupingBy(String::length)); // group by length
        wordsGroupedByLength.forEach((k, v) -> System.out.println(k + ": " + v));
        //List<String> wordsWithLengthThree = wordsGroupedByLength.get(3);
        //wordsWithLengthThree.forEach(System.out::println);

        String peopleNamesAsString = people.stream()
                .map(PersonToCollect::getName)
                .collect(Collectors.joining(", "));
        System.out.println(peopleNamesAsString);

        // special case for group by length
        Map<Boolean, List<String>> myWordsTrueIfLengthGreaterThan4 = myWords.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 4));
        myWordsTrueIfLengthGreaterThan4.forEach((k, v) -> System.out.println(k + ": " + v));
        // only true
        myWordsTrueIfLengthGreaterThan4.get(true).forEach(System.out::println);
        System.out.println("");

        Map<String, List<PersonToCollect>> addressGroupBy = people.stream()
                .collect(
                        Collectors.
                                groupingBy(
                                        PersonToCollect::getAddress
                                )
                );
        addressGroupBy.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("");

        // how often each address occurs in the list of people
        Map<String, Long> addressHowOften = people.stream()
                .collect(
                        Collectors.
                                groupingBy(
                                        PersonToCollect::getAddress,
                                        Collectors.counting()
                                )
                );
        addressHowOften.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("");
        // how many people living in JavaVillage
        System.out.println(addressHowOften.get("JavaVillage"));

        // 1. approach : village with oldest, people
        Map<String, Optional<PersonToCollect>> villageOldestPeople = people.stream()
                .collect(
                        Collectors.groupingBy(
                                PersonToCollect::getAddress,
                                Collectors.maxBy(
                                        Comparator.comparing(PersonToCollect::getAge)
                                )
                        )
                );
        villageOldestPeople.forEach((k, v) -> System.out.println(k + ": " + v));
        // JavaCity
        System.out.println(villageOldestPeople.get("JavaCity").get().getName());


        // 2. approach : village with oldest, people
        Map<String, PersonToCollect> villageOldestPeople2 = people.stream()
                .collect(
                        Collectors.groupingBy(
                                PersonToCollect::getAddress,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(PersonToCollect::getAge)),
                                        Optional::get
                                )
                        )
                );
        villageOldestPeople2.forEach((k, v) -> System.out.println(k + ": " + v));
        // JavaCity
        System.out.println(villageOldestPeople2.get("JavaCity").getName());
        System.out.println("");

        Stream<String> myWordsStream = Stream.of("one", "two", "three", "four", "five", "six", "seven");
        // is complex but makes sense for parallel processing from data
        myWords = myWordsStream.collect(
                // is used as a supplier
                ArrayList::new,
                // Accumulator takes two parameters, current collection and the next element from the stream
                // is used as the accumulator, which adds each element to the ArrayList
                List::add,
                // Combiner, function takes two collections and combines them into a single collection.
                // is used as combiner, which adds all elements from the second collection to the first collection-
                List::addAll
        );
        myWords.forEach(System.out::println);

        Stream<List<String>> myWordsToList = Stream.empty();
        myWords = myWordsToList.collect(
                // Supplier collect as result
                ArrayList::new,
                // Accumulator
                List::addAll,
                // Combiner
                List::addAll
        );

        /*myWordsToList = Stream.empty();
        myWordsToList.flatMap(liste -> liste.stream()).collect(Collectors.toList());*/
    }
}

class PersonToCollect {
    String name;
    String address;
    int age;

    PersonToCollect(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
