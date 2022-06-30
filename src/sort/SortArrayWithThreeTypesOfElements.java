package sort;

import java.util.Arrays;
import java.util.stream.IntStream;

import static sort.HeapSort.swap;

public class SortArrayWithThreeTypesOfElements {

    public static void main(String[] args) {

        System.out.println("SortArrayWithThreeTypesOfElements");

        System.out.println(Arrays.toString(sort(IntStream.of(0, 1, 0, 2, 1, 2).toArray()))); // Group 0s and 1s and 2s together
        System.out.println(Arrays.toString(sort(IntStream.of(2, 1, 2, 20, 10, 20, 1).toArray()))); // Pivot is 2 and less than 2 is left all 2s in middle and all > 2s in right
        System.out.println(Arrays.toString(sort(IntStream.of(10, 5, 6, 3, 21, 20, 9, 30, 40).toArray()))); // Range [5,10] all less than range in left and range in middle and greater than range in right side

    }

    private static int[] sort(int[] arr) {

        int low = -1;
        int mid = -1;
        for (int high = 0; high < arr.length; high++) {
            if (mid < low)
                mid = low;
            if (arr[high] == 1) // if ((arr[high] >= 5 && arr[high] <= 10))
                swap(arr, high, ++mid);

            if (arr[high] == 0) { // if (arr[high] < 5) {
                swap(arr, high, ++low);
                if (arr[high] == 1) // if ((arr[high] >= 5 && arr[high] <= 10))
                    swap(arr, high, ++mid);
            }
        }

        return arr;
    }


}
