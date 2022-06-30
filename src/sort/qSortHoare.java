package sort;

import java.util.Arrays;
import java.util.Random;

import static sort.HeapSort.swap;

// 11:35
public class qSortHoare {

    public static void main(String[] args) {
        System.out.println("hoare");
//        int[] arr = {4, 8, 3, 9, 1};
//        int[] arr = {1, 1};
        int[] arr = {5, 8, 2, 5, 9};
        qSort(arr);
        System.out.println(Arrays.toString(arr));
    }

//    int[] arr = {5, 8, 2, 5, 9};

    private static void qSort(int[] arr) {
        int r = new Random().nextInt(arr.length);
        swap(arr, 0, r);
        qSort(arr, 0, arr.length - 1);
    }

    private static void qSort(int[] arr, int l, int h) {
        if (l < h) {
            int p = hoarePartition(arr, l, h);
            qSort(arr, l, p); // This is important  (p - 1) is bad option, that will exclude elements.
            qSort(arr, p + 1, h);
        }
    }

    private static int hoarePartition(int[] arr, int l, int h) {
        int pivot = arr[l];
        int i = l - 1; // since do while go one step back
        int j = h + 1; // since do while go one step ahead
        while (true) {
            do { // do while important, else infinite loop happens after
                // first swap, need to increment and check condition
                i++;
            } while (arr[i] < pivot); // <= is a bad option,
            // as the first element will get stuck in its position
            // and sorting will be wrong
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) return j; // no need to do for == as it is same value/index
             // return "j" is key, returning "i" will include higher value to left side
            // and right side of pivot is not all sorted yet, so final result won't be sorted
            // safer bet is to return "j"
            swap(arr, i, j);
        }
    }

    private static int hoarePartition1(int[] arr, int l, int h) {

        int pivot = arr[l];
        l--;
        h++;
        while (l < h) {
            do { // do while important, else infinite loop happens after
                // first swap, need to increment and check condition
                l++;
            } while (arr[l] < pivot); // <= is a bad option,
            // as the first element will get stuck in its position
            // and sorting will be wrong
            do {
                h--;
            } while (arr[h] > pivot);
            if (l < h) { // no need to do for == as it is same value/index
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
            }
        }
        return h;
    }
}
