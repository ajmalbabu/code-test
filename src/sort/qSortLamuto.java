package sort;

import java.util.Arrays;

import static sort.HeapSort.swap;

// 9:39 - 10:00
public class qSortLamuto {

    public static void main(String[] args) {
        System.out.println("test");
        int[] arr = {4, 8, 3, 9, 1};
//        int[] arr = {1, 1};
//        int[] arr = {5, 8, 2, 5, 9};
        qSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void qSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int l, int h) {
        if (l < h) {
            int p = lomutoPartition(arr, l, h);
            qSort(arr, l, p - 1);
            qSort(arr, p + 1, h);
        }
    }

    private static int lomutoPartition(int[] arr, int l, int h) {

        int pivot = arr[h]; // randomly pick pivot & swap to end, so folks know
                            // this algorithm can't manipulate how?
        int slow = l - 1; // "l-" is key
        for (int fast = l; fast < h; fast++) {
            if (arr[fast] < pivot) { // < Addl swap for last element, so lesser
                                     // movement of elements
                swap(arr, ++slow, fast);
            }
        }
        swap(arr, ++slow, h);
        return slow;
    }

}
