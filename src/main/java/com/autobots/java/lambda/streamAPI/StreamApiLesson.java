package com.autobots.java.lambda.streamAPI;

import java.time.temporal.JulianFields;
import java.util.*;
import java.util.stream.Collectors;

public class StreamApiLesson {
    public static void main(String[] args) {

        List<String> names = List.of("Anna", "Bob", "Alex", "Bella", "Andrew");

//        List<String> nameWithA = new ArrayList<>();
//        for (String name : names) {
//            if (name.startsWith("A")) ;
//            nameWithA.add(name.toUpperCase());
//            Collections.sort(nameWithA);
//        }
//        System.out.println(nameWithA);


//        List<String> result = names.stream()
//                .filter(name -> name.startsWith("A"))
//                .map(String::toUpperCase)
//                .sorted()
//                .collect(Collectors.toList());
//        System.out.println(result);
//
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        int r1 = 0;
//        for (int num : numbers){
//            r1 += num;
//
//        }
//        System.out.println(r1);
//
//        int total = numbers.stream()
//                .mapToInt(num -> num)
//                .sum();
//        System.out.println(total);
//
//        int totalElements = (int) numbers.stream()
//                .count();
//        System.out.println(totalElements);
//
//        numbers.stream()
//                .min(Integer::compareTo)
//               .ifPresent(System.out::println);
//
//        List<String> list = List.of("one", "two", "three", "Hello", "four", "five");
//        list.stream()
//                .filter(s-> s.length()>3)
//                .findFirst()
//                .ifPresent(System.out::println);


//            List<Employee> itEmployees = employees.stream()
//                    .filter(s->s.getDepartment().equals("IT"))
//                    .collect(Collectors.toList());
//        System.out.println(itEmployees);
//
//        employees.stream()
//                .filter(s->s.getDepartment().equals("IT")).forEach(System.out::println);
//
//        List<Employee> itEmployees2 = new ArrayList<>();
//        for (Employee employee : employees){
//            if (employee.getDepartment().equalsIgnoreCase("IT")){
//                itEmployees2.add(employee);
//            }
//        }
//        System.out.println(itEmployees2);
        List<Employee> employees = List.of(
                new Employee(1, "Alice", 28, 3000, "IT"),
                new Employee(2, "Bob", 35, 4000, "HR"),
                new Employee(3, "Charlie", 40, 5000, "Finance"),
                new Employee(4, "David", 36, 3500, "IT"),
                new Employee(5, "Eva", 22, 4200, "Marketing"),
                new Employee(6, "Frank", 45, 6000, "Finance"),
                new Employee(7, "Grace", 32, 4100, "HR"),
                new Employee(8, "Henry", 27, 3900, "IT"),
                new Employee(9, "Isabel", 38, 4500, "Marketing"),
                new Employee(10, "jack", 30, 3600, "IT")
        );

//        Map<String, List<Employee>> employeesByDepartment = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment));
//        employeesByDepartment.forEach((department, employeeList) -> {
//            System.out.println("Department: " + department);
//            employeeList.forEach(System.out::println);
//            System.out.println();
//        });

//        Map<String, List<Employee>> employeesByDepartment2 = new HashMap<>();
//        for (Employee employee : employees) {
//            String department = employee.getDepartment();
//            if (!employeesByDepartment2.containsKey(department)) {
//                employeesByDepartment2.put(department, new ArrayList<>());
//            }
//            employeesByDepartment2.get(department).add(employee);
//        }
//        employeesByDepartment2.forEach((department, employeeList) -> {
//            System.out.println("Department: " + department);
//            employeeList.forEach(System.out::println);
//            System.out.println();
//        });

//        Map<String, Double> totalSalaryByDep = new HashMap<>();
//        Map<String, Integer> averageSalaryByDep = new HashMap<>();
//
//        for (Employee employee : employees) {
//            averageSalaryByDep.put(employee.getDepartment(),
//                    averageSalaryByDep.getOrDefault(employee.getDepartment(), 0)
//                            + employee.getSalary());
//            totalSalaryByDep.put(employee.getDepartment(),
//                    totalSalaryByDep.getOrDefault(employee.getDepartment(), 0.0) +1);
//        }
//
//        double salary = 0.0;
//        for (String dep : averageSalaryByDep.keySet()) {
//            salary = averageSalaryByDep.get(dep) / totalSalaryByDep.get(dep);
//            System.out.printf("%s -> $%.2f%n", dep, salary);
//        }
//        System.out.println("__________________________________");
//
//        Map<String, Double> averageSalaryByDepWithStream = employees.stream()
//                .collect(Collectors.groupingBy(Employee::getDepartment,
//                        Collectors.averagingDouble(Employee::getSalary)));
//
//        averageSalaryByDepWithStream.forEach((dep, averSalary) ->
//                System.out.println(dep + " ->  $" + averSalary));
//
//        System.out.println("__________________________________");
//
//        for (Map.Entry<String, Double> entry : averageSalaryByDepWithStream.entrySet()) {
//            System.out.println(entry.getKey() + " -> $" + entry.getValue());
//        }

        Map<String, Double> averageSalaryByDepWithStream2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        averageSalaryByDepWithStream2.forEach((department, averageSalary) ->
                System.out.printf("%s -> $%.2f%n", department, averageSalary));

    }
    }

