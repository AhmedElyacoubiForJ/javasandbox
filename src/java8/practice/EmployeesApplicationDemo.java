package java8.practice;

import java8.practice.data.Employee;
import java8.practice.data.Employees;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class EmployeesApplicationDemo {
    public static List<Employee> employees = Employees.getEmployees();
    public static void main(String[] args) {
        // 1. How many male and female employees are there in the organization?
        printCountEmployeeGroupByGender();

        // 2. Print the name of all departments in the organization, sorted?
        printDepartmentNamesSorted();

        // 3. What is the average age of male and female employees?

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

    public static long employeesAgeGreaterThan(int age) {
        return employees.stream()
                .filter(e -> e.getAge() > age)
                .collect(toList()).stream().count();
    }
}
