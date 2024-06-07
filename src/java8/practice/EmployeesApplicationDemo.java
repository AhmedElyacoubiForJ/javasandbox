package java8.practice;

import java8.practice.data.Employee;
import java8.practice.data.Employees;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class EmployeesApplicationDemo {
    public static List<Employee> employees = Employees.getEmployees();

    public static void main(String[] args) {
        // printEmployeesAgeGreaterThan(30);

        // 1. How many male and female employees are there in the organization?
        //printCountEmployeeGroupByGender();

        // 2. Print the name of all departments in the organization, sorted?
        //printDepartmentNamesSorted();

        // 3. What is the average age of male and female employees?
        //printAverageAgeByGender();

        // 4. Get the details of highest paid employee in the organization?
        //printHighestPaidEmployee();

        // 5. Get the names of all employees who have joined after 2015, sorted?
        //printSortedEmployeesJoinedAfter2025();

        // 6. Count the number of employees in each department?
        //printNumberOfEmployeesInEachDepartment();

        // 7. What is the average salary of each department?
        //printAverageSalaryPerDepartment();

        // 8. Get the details of youngest male employee in the product development department?
        //printYoungestMaleInProductDevelopmentDepartment();

        // 9. Who has the most working experience in the organization?
        //printWithMoreExperience();

        // 10. How many male and female employees are there in the sales and marketing team?
        //printNumberPerGenderInSalesAndMarketingDepartment();

        // 11. What is the average salary of male and female employees?
        //printAverageSalaryPerGender();

        // 12. List down the names of all employees in each department?
        //printNamesPerDepartment();

        // 13. What is the average salary and total salary of the whole organization?
        //printSalaryStatisticsOfTheOrganisation();

        // 14. Separate the employees who are younger or equal to 25 years
        //     from those employees who are older than 25 years.
        // printYoungerOrEqualTo25();

        // 15. Who is the oldest employee in the organization?
        //     What is his age and which department he belongs to?
        printOldestEmployee();

    }

    private static void printOldestEmployee() {
        Optional<Employee> oldestEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getAge));
        System.out.println("Name : " + oldestEmployee.get().getName());
        System.out.println("Age : " + oldestEmployee.get().getAge());
        System.out.println("Department : " + oldestEmployee.get().getDepartment());
    }

    private static void printYoungerOrEqualTo25() {
        // 1. approach
        Predicate<Employee> isYoungerOrEqualTo25 = e -> e.getAge() <= 25;
        employees.stream()
                .filter(isYoungerOrEqualTo25)
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("");
        employees.stream()
                .filter(isYoungerOrEqualTo25.negate())
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("");

        // 2. approach
        Map<Boolean, List<String>> collect = employees.stream()
                .collect(Collectors.partitioningBy(
                                isYoungerOrEqualTo25,
                                Collectors.mapping(Employee::getName, toList())
                        )
                );

        collect.get(Boolean.TRUE).forEach(System.out::println);
        System.out.println("");
        collect.get(Boolean.FALSE).forEach(System.out::println);
    }

    private static void printSalaryStatisticsOfTheOrganisation() {
        // 1. approach
        DoubleSummaryStatistics salaryStatistics = employees.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();
        System.out.println("Average Salary = " + salaryStatistics.getAverage());
        System.out.println("Total Salary = " + salaryStatistics.getSum());
        //System.out.println(salaryStatistics);

        System.out.println("");
        // 2. approach
        DoubleSummaryStatistics salaryStatistics2 = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary = " + salaryStatistics2.getAverage());
        System.out.println("Total Salary = " + salaryStatistics2.getSum());
    }

    private static void printNamesPerDepartment() {
        // classify by gender, mapping by name and collect the mapping result to toList
        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(Employee::getName, toList())
                        )
                )
                .forEach((k, v) -> System.out.println(k + "=" + v));
    }

    private static void printAverageSalaryPerGender() {
        // classify by gender, salary average as reduce operation
        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                )
                .forEach((k, v) -> System.out.println(k + "=" + v));
    }

    private static void printNumberPerGenderInSalesAndMarketingDepartment() {
        // 1. filter by department
        // 2. classify by gender, counting as reduce operation
        Predicate<Employee> isSalesAndMarketing = e -> "Sales And Marketing".equals(e.getDepartment());
        employees.stream()
                .filter(isSalesAndMarketing)
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "=" + v));
    }

    private static void printWithMoreExperience() {
        // 1. approach
        employees.stream()
                .min(Comparator.comparingInt(Employee::getYearOfJoining))
                .ifPresent(System.out::println);
        // 2. approach
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getYearOfJoining))
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void printYoungestMaleInProductDevelopmentDepartment() {
        Predicate<Employee> isProductDevelopment = e -> "Product Development".equals(e.getDepartment());
        Predicate<Employee> isMale = e -> "Male".equals(e.getGender());

        Predicate<Employee> isProductDevelopmentAndMale = isProductDevelopment.and(isMale);

        employees.stream()
                .filter(isProductDevelopmentAndMale)
                .min(Comparator.comparingInt(Employee::getAge))
                .ifPresent(System.out::println);
    }

    private static void printAverageSalaryPerDepartment() {
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ))
                .forEach((gKey, gValue) -> System.out.println(gKey + " : " + gValue));
    }

    private static void printNumberOfEmployeesInEachDepartment() {
        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartment, // classifier
                                Collectors.counting()    // reducer
                        )
                )
                .forEach((gKey, gValue) -> System.out.println(gKey + " : " + gValue));
    }

    private static void printSortedEmployeesJoinedAfter2025() {
        employees.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(e -> e.getName())
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    private static void printHighestPaidEmployee() {
        // 1. approach
        BinaryOperator<Employee> withSalaryGreater = (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2;
        employees.stream().reduce(withSalaryGreater)
                .ifPresent(System.out::println);

        // 2. approach
        employees.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
                .ifPresent(System.out::println);
    }

    private static void printAverageAgeByGender() {
        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getGender, // classifier
                                //Collectors.mapping(Employee::getAge, toList())
                                Collectors.averagingDouble(Employee::getAge) // downstream reduction
                        )
                )
                .forEach((genderKey, averageValue) -> System.out.println(genderKey + " : " + averageValue));
    }

    private static void printDepartmentNamesSorted() {
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    public static void printCountEmployeeGroupByGender() {
        // employees grouped by gender
        Map<String, List<Employee>> employeesGroupByGender = employees.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.toList()));
        //employeesGroupByGender.forEach((gKey, eValue) -> System.out.println(gKey + " : " + eValue));

        // employees name grouped by gender
        Map<String, List<String>> employeesNameGroupByGender = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.mapping(Employee::getName, toList()
                        )
                ));
        //employeesNameGroupByGender.forEach((gKey, nValue) -> System.out.println(gKey + " : " + nValue));

        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.counting()
                        )
                )
                .forEach((gKey, gValue) -> System.out.println(gKey + " : " + gValue));
    }

    public static void printEmployeesAgeGreaterThan(int age) {
        System.out.println(employees.stream().filter(e -> e.getAge() > age).count());
    }
}
