package java8.practice;

import java8.practice.data.Employee;
import java8.practice.data.Employees;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
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
        printAverageSalaryPerDepartment();

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
