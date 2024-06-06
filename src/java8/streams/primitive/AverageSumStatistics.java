package java8.streams.primitive;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;

public class AverageSumStatistics {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(26, 1000),
                new Person(30, 1500),
                new Person(37, 1300)
        );
        //min age
        int minAge = people.stream()
                .mapToInt(person -> person.age)
                .min()
                .getAsInt();
        System.out.println(minAge);

        // max salary
        int maxSalary = people.stream()
               .mapToInt(person -> person.salary)
               .max()
               .getAsInt();
        System.out.println(maxSalary);

        // average age
        double averageAge = people.stream()
                .mapToInt(person -> person.age)
                .average()
                .getAsDouble();
        System.out.println(averageAge);

        // 1. approach : sum salary
        int sumSalary = people.stream()
                .mapToInt(person -> person.salary)
                .sum();
        System.out.println(sumSalary);
        // 2. approach : sum salary
        sumSalary = people.stream()
                .mapToInt(person -> person.salary)
                .reduce(0, ((left, right) -> left + right));
        System.out.println(sumSalary);

        //
        IntSummaryStatistics salaryStatistics = people.stream()
                .mapToInt(person -> person.salary)
                .summaryStatistics();
//        System.out.println(salaryStatistics.getAverage());
//        System.out.println(salaryStatistics.getMax());
//        System.out.println(salaryStatistics.getMin());
//        System.out.println(salaryStatistics.getSum());
//        System.out.println(salaryStatistics.getCount());
        System.out.println(salaryStatistics);

       /* // average salary
        double averageSalary = people.stream()
               .mapToInt(person -> person.salary)
               .average()
               .getAsDouble();
        System.out.println(averageSalary);

        // count
        long count = people.stream()
               .mapToInt(person -> person.salary)
               .count();
        System.out.println(count);*/

    }
}

class Person {
    int age;
    int salary;
    public Person(int age, int salary) {
        this.age = age;
        this.salary = salary;
    }
}
