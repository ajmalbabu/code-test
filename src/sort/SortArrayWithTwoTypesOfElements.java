package sort;

import java.util.Arrays;
import java.util.stream.IntStream;

import static sort.HeapSort.swap;

public class SortArrayWithTwoTypesOfElements {

    public static void main(String[] args) {
        System.out.println("test");
        System.out.println(Arrays.toString(sortLamuto(IntStream.of(13, -12, 18, -10).toArray())));
        System.out.println(Arrays.toString(sortHoare(IntStream.of(13, -12, 18, -10).toArray())));
    }

    private static int[] sortLamuto(int[] arr) {

        int slow = -1;
        for (int fast = 0; fast < arr.length; fast++) {
            if (arr[fast] < 0) {
                swap(arr, ++slow, fast);
            }
        }
        return arr;
    }

    private static int[] sortHoare(int[] arr) {

        int l = -1;
        int r = arr.length;

        while (true) {
            do {
                l++;
            } while (arr[l] <= 0);

            do {
                r--;
            } while (arr[r] > 0);

            if (l >= r) break;

            swap(arr, l, r);

        }

        return arr;
    }

}
