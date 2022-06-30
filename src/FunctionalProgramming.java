import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming {
    public static void main(String[] args) {

        ComparatorTest.Employee sam = new ComparatorTest.Employee(25, "sam");
        ComparatorTest.Employee alex = new ComparatorTest.Employee(27, "alex");
        ComparatorTest.Employee john = new ComparatorTest.Employee(21, "john");
        List<ComparatorTest.Employee> employees = new ArrayList<>(List.of(sam, alex, john));

        List<ComparatorTest.Employee> f = employees.stream().filter(e -> e.getAge() > 3).collect(Collectors.toList());
        System.out.println(f);    }
}
