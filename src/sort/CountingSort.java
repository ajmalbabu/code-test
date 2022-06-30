package sort;

import java.util.Arrays;
import java.util.function.ToIntFunction;

public class CountingSort {

    public static void main(String[] args) {

        System.out.println("counting sort");
        int[] arr = {0, 6, 4, 6, 4, 5, 6, 2, 1, 1, 0};
        System.out.println(Arrays.toString(arr));
        sort(arr, 7); // important to pass 7 for 0 - 6 elements.
        // How is -ve numbers handled? seperate -ve array and cumulative
        // is taken from -ve forst then +ve array starts from -ve cumulative sum
        System.out.println(Arrays.toString(arr));

        Employee[] employees = new Employee[4];
        employees[0] = new Employee("pete", 1);
        employees[1] = new Employee("james", 3);
        employees[2] = new Employee("jon", 2);
        employees[3] = new Employee("mark", 1);

        System.out.println(Arrays.toString(employees));
//        sortNonIntArray(employees, 4);
        sortGenericArray(employees, 4, Employee::getVal);
        System.out.println(Arrays.toString(employees));

        int[] arr1 = {-2, 0, 1, 4, 1, -2, 3};
        System.out.println(Arrays.toString(arr1));
        sort(arr1, -3, 5);
        System.out.println(Arrays.toString(arr1));
    }


    private static void sort(int[] arr, int k) {

        int[] count = new int[k];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }
        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) { // starting from n - 1 to get stable sort
            sorted[count[arr[i]] - 1] = arr[i]; // -1 since arr[0] = 1, if there is a 0 value
                                                // in the input array arr[0] - 1 = 1 - 1 = 0
            count[arr[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
    }


    private static void sortNonIntArray(Employee[] arr, int k) {

        int[] count = new int[k];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i].val]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }
        Employee[] sorted = new Employee[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[count[arr[i].val] - 1] = arr[i];
            count[arr[i].val]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
    }

    private static <T> void sortGenericArray(T[] arr, int k, ToIntFunction<? super T> sortMethod) {

        int[] count = new int[k];
        for (T t : arr) {
            count[sortMethod.applyAsInt(t)]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }
        Object[] sorted = new Object[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            sorted[count[sortMethod.applyAsInt(arr[i])] - 1] = arr[i];
            count[sortMethod.applyAsInt(arr[i])]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (T) sorted[i];
        }
    }

    static class Employee {
        int val;
        String name;

        Employee(String name, int val) {
            this.val = val;
            this.name = name;
        }

        public int getVal() {
            return val;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "val=" + val +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    // input => -2,0,1,4,1,-2,3    min - -3, max = 5
    private static void sort(int[] arr, int kMin, int kMax) {

        int[] count = new int[kMax];
        int[] countNegative = new int[Math.abs(kMin)];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0)
                count[arr[i]]++;
            else
                countNegative[Math.abs(arr[i])]++;
        }

        for (int i = countNegative.length - 2; i >= 0; i--) {
            countNegative[i] = countNegative[i + 1] + countNegative[i];
        }

        count[0] += countNegative[0];

        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }
        int[] sorted = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 0) {
                sorted[countNegative[Math.abs(arr[i])] - 1] = arr[i];
                countNegative[Math.abs(arr[i])]--;
            } else {
                sorted[count[arr[i]] - 1] = arr[i];
                count[arr[i]]--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }

    }
}
