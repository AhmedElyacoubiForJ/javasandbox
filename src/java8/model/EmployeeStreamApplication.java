package java8.model;

public class EmployeeStreamApplication {
    public static void main(String[] args) {
        Employees.getEmployees().forEach(System.out::println);
    }
}
