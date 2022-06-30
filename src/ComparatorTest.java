import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

// https://www.techiedelight.com/sort-list-of-objects-using-comparator-java/
public class ComparatorTest {
    public static void main(String[] args) {

        Employee sam = new Employee(25, "sam");
        Employee alex = new Employee(27, "alex");
        Employee john = new Employee(21, "john");

        array(sam, alex, john);
        list(sam, alex, john);
        listFunctional(sam, alex, john);


    }

    private static void list(Employee sam, Employee alex, Employee john) {
        List<Employee> employees = new ArrayList<>(List.of(sam, alex, john));
        System.out.println("List based");
        System.out.println(employees);
        Collections.sort(employees, new AgeComparator());
        System.out.println(employees);


    }

    private static void listFunctional(Employee sam, Employee alex, Employee john) {
        System.out.println("List based functional");
        List<Employee> employees = new ArrayList<>(List.of(sam, alex, john));
        System.out.println(employees);
        Collections.sort(employees, (e1, e2) -> e1.age - e2.age); // or below
        Collections.sort(employees, comparingInt(e -> e.age)); // or below
        Collections.sort(employees, comparingInt(Employee::getAge));
        System.out.println(employees);

        // Compare mame and age
        employees.sort(comparing(Employee::getName).thenComparing(Employee::getAge));
        System.out.println(employees);
    }

    private static void array(Employee sam, Employee alex, Employee john) {

        System.out.println("Array based");
        Employee[] employeesArray = new Employee[3];
        employeesArray[0] = sam;
        employeesArray[1] = alex;
        employeesArray[2] = john;

        System.out.println(Arrays.toString(employeesArray));
//        Arrays.sort(employeesArray); // or below
        Arrays.sort(employeesArray, new AgeComparator());
        System.out.println(Arrays.toString(employeesArray));
    }

    static class Employee implements Comparable<Employee> {
        private int age;
        private String name;

        public Employee(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Employee o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "age=" + age +
                    '}';
        }
    }

    static class AgeComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.age - o2.age;
        }
    }
}
