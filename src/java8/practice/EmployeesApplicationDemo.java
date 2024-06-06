package java8.practice;

import java8.practice.data.Employee;
import java8.practice.data.Employees;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeesApplicationDemo {
    public static List<Employee> employees = Employees.getEmployees();
    public static void main(String[] args) {
        employees.forEach(System.out::println);
        // employees age greater than 30
        System.out.println(employeesAgeGreaterThan(30));

    }

    public static long employeesAgeGreaterThan(int age) {
        return employees.stream()
                .filter(e -> e.getAge() > age)
                .collect(Collectors.toList()).stream().count();
    }
}
