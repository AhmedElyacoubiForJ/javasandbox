package java8.tasks_solutions;

import java8.tasks_solutions.data.Employee;
import java8.tasks_solutions.data.Employees;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class EmployeesApplicationDemo {
    public static List<Employee> employees = Employees.getEmployees();

    public static void main(String[] args) {
         //printEmployeesAgeGreaterThan(30);

        // 1. How many male and female employees are there in the organization?
        //printEmployeesNumberPerGender();

        // 2. Print the name of all departments in the organization, sorted?
        //printDepartmentNamesSorted();

        // 3. What is the average age of male and female employees?
        //printAgeAverageByGender();

        // 4. Get the details of highest paid employee in the organization?
        //printHighestPaidEmployee();

        // 5. Get the names of all employees who have joined after 2015, sorted?
        //printEmployeesJoinedAfter2025Sorted();

        // 6. Count the number of employees in each department?
        //printNumberOfEmployeesInEachDepartment();

        // 7. What is the average salary of each department?
        //printSalaryAveragePerDepartment();

        // 8. Get the details of youngest male employee in the product development department?
        //printYoungestMaleInProductDevelopment();

        // 9. Who has the most working experience in the organization?
        //printEmployeeWithMoreExperience();

        // 10. How many male and female employees are there in the sales and marketing team?
        // printNumberInSalesAndMarketingDepartmentPerGender();

        // 11. What is the average salary of male and female employees?
        //printSalaryAveragePerGender();

        // 12. List down the names of all employees in each department?
        //printEmployeeNamesPerDepartment();

        // 13. What is the average salary and total salary of the whole organization?
        printSalaryStatisticsOfTheOrganisation();

        // 14. Separate the employees who are younger or equal to 25 years
        //     from those employees who are older than 25 years.
        // printYoungerOrEqualTo25();

        // 15. Who is the oldest employee in the organization?
        //     What is his age and which department he belongs to?
        //printOldestEmployee();

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

    private static void printEmployeeNamesPerDepartment() {
        // collect steps: classify by gender, mapping by name and collect the mapping result to toList
        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(Employee::getName, toList())
                        )
                )
                .forEach((k, v) -> System.out.println(k + " = " + v));
    }

    private static void printSalaryAveragePerGender() {
        // collect steps: classify by gender, averagingDouble collector as reducer
        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                )
                .forEach((genderKey, salaryAverageValue) -> System.out.println(genderKey + " = " + salaryAverageValue));
    }

    private static void printNumberInSalesAndMarketingDepartmentPerGender() {
        Predicate<Employee> isSalesAndMarketing = e -> "Sales And Marketing".equals(e.getDepartment());
        // filter by defined department
        // & collect with classified gender
        // & reduce with counting collector
        employees.stream()
                .filter(isSalesAndMarketing)
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()))
                .forEach((genderKey, countValue) -> System.out.println(genderKey + " = " + countValue));
    }

    private static void printEmployeeWithMoreExperience() {
        Comparator<Employee> comparator = Comparator.comparingInt(Employee::getYearOfJoining);

        // 1. approach
        // either using the min method
        employees.stream()
                .min(comparator)
                .ifPresent(System.out::println);
        // 2. approach
        // or the sorted method, with respectively the same comparator
        employees.stream()
                .sorted(comparator)
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void printYoungestMaleInProductDevelopment() {
        Predicate<Employee> isProductDevelopment = e -> "Product Development".equals(e.getDepartment());
        Predicate<Employee> isMale = e -> "Male".equals(e.getGender());
        Predicate<Employee> isBoth = isProductDevelopment.and(isMale);

        // filter using the implemented chained filter
        // & reduce by using the comparingInt comparator w. age as key extractor
        employees.stream()
                .filter(isBoth)
                .min(Comparator.comparingInt(Employee::getAge))
                .ifPresent(System.out::println);
    }

    private static void printSalaryAveragePerDepartment() {
        // classify by department & reduce by averageDouble collector mapped by salary
        employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ))
                .forEach((departmentKey, salaryAverageValue) ->
                        System.out.println(departmentKey + " : " + salaryAverageValue));
    }

    private static void printNumberOfEmployeesInEachDepartment() {
        // classify by department & reduce by number of employees using the counting collectors
        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getDepartment, // classifier
                                Collectors.counting()    // reducer
                        )
                )
                .forEach((departmentKey, countValue) -> System.out.println(departmentKey + " : " + countValue));
    }

    private static void printEmployeesJoinedAfter2025Sorted() {
        Predicate<Employee> isJoinedAfter2015 = e -> e.getYearOfJoining() > 2015;

        employees.stream()
                .filter(isJoinedAfter2015)
                .map(Employee::getName)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    private static void printHighestPaidEmployee() {
        // 1. approach
        // reduce using binary operator
        BinaryOperator<Employee> greaterSalary = (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2;
        employees.stream().reduce(greaterSalary)
                .ifPresent(System.out::println);

        // 2. approach streams api
        // collect using maxBy collector & compare with comparing comparator.
        employees.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
                .ifPresent(System.out::println);
    }

    private static void printAgeAverageByGender() {
        // classify by gender & reduce using averageDouble collector
        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getGender, // classifier
                                Collectors.averagingDouble(Employee::getAge) // downstream reduction
                        )
                )
                .forEach((genderKey, averageValue) -> System.out.println(genderKey + " : " + averageValue));
    }

    private static void printDepartmentNamesSorted() {
        // map employee to department & remove duplicates & sort by natural order
        employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    public static void printEmployeesNumberPerGender() {
        // classify by gender & collect employee to list
        Map<String, List<Employee>> employeesGroupByGender = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.toList()
                        )
                );
        //employeesGroupByGender.forEach((gKey, eValue) -> System.out.println(gKey + " : " + eValue));

        // classify by gender & collect mapped employees by name to list
        Map<String, List<String>> employeesNameGroupByGender = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                        )
                );
        //employeesNameGroupByGender.forEach((gKey, nValue) -> System.out.println(gKey + " : " + nValue));

        // classify by gender & reduce by counting collector
        employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getGender,
                                Collectors.counting()
                        )
                )
                .forEach((gKey, gValue) -> System.out.println(gKey + " : " + gValue));
    }

    public static void printEmployeesAgeGreaterThan(int age) {
        employees.stream()
                .filter(e -> e.getAge() > age)
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
