package ua.goit.module10.LessonTask;

import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Employee sara = new Employee("Sara", 45);
        Employee bibiktor = new Employee("bibiktor", 33);
        Employee loya = new Employee("Loya", 56);
        Employee loly = new Employee("Loly", 3335);
        List<Employee> collection = Arrays.asList(sara, bibiktor, loya, loly);

        //without stream api
        Employee resultEmployee = null;

        for (Employee employee : collection) {
            if (resultEmployee == null) {
                resultEmployee = employee;
            } else if (employee.getAge() > resultEmployee.getAge()) {
                resultEmployee = employee;
            }
        }

        System.out.println(resultEmployee.getName() + " is the oldest person");

        //with stream api
        final Optional<Employee> maxEmployee = collection.stream()
                .max(Comparator.comparing(Employee::getAge));
        final Employee employee = maxEmployee.orElse(new Employee("Andrew", 43));

        System.out.println(employee);
    }
}


class Employee {
    private String name;
    private int age;
    private String nationality;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, int age, String nationality) {
        this(name, age);
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(nationality, employee.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, nationality);
    }
}
